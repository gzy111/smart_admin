package com.example.smart_admin.controller;

import com.example.smart_admin.domain.Document;
import com.example.smart_admin.service.DocumentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/File")
public class FileUploadController {

    @Autowired
    DocumentService documentService;
    @PostMapping("/UploadImage")
    @ResponseBody
    //将上传的文件放在tomcat目录下面的file文件夹中
    public String upload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取到原文件全名
        String originalFilename = multipartFile.getOriginalFilename();
        // request.getServletContext()。getRealPath("")这里不能使用这个，这个是获取servlet的对象，并获取到的一个临时文件的路径，所以这里不能使用这个
        //这里获取到我们项目的根目录，classpath下面
        String realPath = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        //文件夹路径,这里以时间作为目录
        String path = realPath + "static/" + format;
        //判断文件夹是否存在，存在就不需要重新创建，不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //转换成对应的文件存储，new File第一个参数是目录的路径，第二个参数是文件的完整名字
        multipartFile.transferTo(new File(file, originalFilename));

        //上传文件的全路径
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + format + "/" + originalFilename;

        Document document=new Document();
        document.setDocumentUrl("/" + format + "/" + originalFilename);
        document.setDocumentName(originalFilename);
        document.setCreateTime(new Date());
        document.setType(multipartFile.getContentType());
        System.out.println();

        documentService.insertSelective(document);
        return url;

    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response, String name, @RequestParam(defaultValue = "0") int isOnline) throws IOException {
        try (ServletOutputStream outputStream = response.getOutputStream();) {
			/*
			这里要使用ResourceUtils来获取到我们项目的根目录
			不能使用request.getServletContext().getRealPath("/")，这里获取的是临时文件的根目录（所以不能使用这个）
			*/
            String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String format = simpleDateFormat.format(new Date());

            String realPath = path + "static/" +  "/" + name;
            System.out.println(realPath);
            File file = new File(realPath);
            //如果下载的文件不存在
            if (!file.exists()) {
                response.setContentType("text/html;charset=utf-8");
                //response.getWriter().write(str);这种写入的就相当于生成了jsp/html，返回html/jsp，所以需要我们进行contentType的设置
                response.getWriter().write("下载的文件不存在");
                return;
            }

            InputStream in = new FileInputStream(realPath);
            int read;

            //byte[] b = new byte[in.available()];创建一个输入流大小的字节数组，然后把输入流中所有的数据都写入到数组中
            byte[] b = new byte[1024];

			/*
			1、Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
			2、attachment表示以附件方式下载   inline表示在线打开   "Content-Disposition: inline; filename=文件名.mp3"
			3、filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
			*/
			/*	注意:文件名字如果是中文会出现乱码：解决办法：
				1、将name 替换为 new String(filename.getBytes(), "ISO8859-1");
				2、将name 替换为 URLEncoder.encode(filename, "utf-8");
			*/
            if (isOnline == 0) {
                //在线打开
                response.addHeader("Content-Disposition", "inline;filename=" + new String(name.getBytes(), "ISO8859-1"));
                System.out.println(0000);
            } else {
                //下载形式，一般跟application/octet-stream一起使用
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes(), "ISO8859-1"));
                //如果单纯写这个也可以进行下载功能，表示以二进制流的形式
                response.setContentType("application/octet-stream");
            }
            //文件大小
            response.addHeader("Content-Length", "" + file.length());
            while ((read = in.read(b)) > 0) {
                outputStream.write(b);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @GetMapping("/DocumentList")
    public PageInfo<Document> Documentlist(Document document){
        PageInfo<Document> pageInfo = documentService.selectByPrimaryKey(document);
        return pageInfo;
    }

}
