package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Document;
import com.example.smart_admin.service.DocumentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/File")
public class FileUploadController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/UploadFile")
    @ResponseBody
    //将上传的文件放在tomcat目录下面的file文件夹中
    public JsonModel<Document> upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonModel<Document> jsonModel = new JsonModel<>();
        //获取到原文件全名
        String originalFilename = multipartFile.getOriginalFilename();
        // request.getServletContext()。getRealPath("")这里不能使用这个，这个是获取servlet的对象，并获取到的一个临时文件的路径，所以这里不能使用这个
        //这里获取到我们项目的根目录，classpath下面
        String realPath = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        //文件夹路径,这里以时间作为目录
        String path = realPath + "static/img/" + format;
        //判断文件夹是否存在，存在就不需要重新创建，不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath=realPath+"static/img/"+format+"/"+originalFilename;
        if (new File(filePath).exists()){
            jsonModel.setCode(403);
            jsonModel.setMsg("文件已经存在");
            return jsonModel;
        }
        //转换成对应的文件存储，new File第一个参数是目录的路径，第二个参数是文件的完整名字
        multipartFile.transferTo(new File(file, originalFilename));
        //上传文件的全路径
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/" + format + "/" + originalFilename;
        Document document = new Document();
        try {
            //当数据库没有一条数据时，返回null，
            document.setId(documentService.selectMaxId()+1);
        }catch (Exception e){

        }
        document.setDocumentUrl("/img/" + format + "/" + originalFilename);
        document.setDocumentName(originalFilename);
        document.setCreateTime(new Date());
        document.setType(multipartFile.getContentType());
        System.out.println(document.toString());
        jsonModel.setData(document);
        documentService.insertSelective(document);
        return jsonModel;

    }



    @RequestMapping("/downloadFile")
    public void downloadFiles(@RequestParam("file") String downUrl, HttpServletRequest request, HttpServletResponse response) throws IOException{
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        byte[] bytes = new byte[1024];
        String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
        System.out.println(downUrl+" down");
        String realPath = path + "static" + downUrl;
        System.out.println(realPath+"   real");
        File file = new File(realPath);
        System.out.println(file.exists());
        String fileName = file.getName();
        System.out.println("本次下载的文件为" + realPath);
        // 获取输出流
        try {
//             StandardCharsets.ISO_8859_1 *='UTF-8'
            // response.setHeader("Content-Disposition", "attachment;filename=" +  new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            response.setCharacterEncoding("UTF-8");
             response.setHeader("Content-Disposition", "attachment;filename=" +  new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
//            response.setHeader("Content-Disposition", "attachment;filename=" +  URLEncoder.encode(fileName, "UTF-8"));
            // 以流的形式返回文件
            response.setContentType("application/octet-stream;charset=utf-8");
            inputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(inputStream);
            outputStream = response.getOutputStream();
            int i = bufferedInputStream.read(bytes);
            while (i!=-1){
                outputStream.write(bytes,0,i);
                i = bufferedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    @GetMapping("/DocumentList")
    public PageInfo<Document> Documentlist(Document document){
        PageInfo<Document> pageInfo = documentService.selectByPrimaryKey(document);
        return pageInfo;
    }



    @PostMapping("/UploadImage")
    @ResponseBody
    //上传头像
    public JsonModel<String> uploadImage(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        JsonModel<String> jsonModel = new JsonModel<>();
        //获取到原文件全名
        String originalFilename = multipartFile.getOriginalFilename();
        // request.getServletContext()。getRealPath("")这里不能使用这个，这个是获取servlet的对象，并获取到的一个临时文件的路径，所以这里不能使用这个
        //这里获取到我们项目的根目录，classpath下面
        String realPath = ResourceUtils.getFile("classpath:").getPath();
        System.out.println(realPath+" rel");
        String path = realPath + "/static/img/head/";
        //判断文件夹是否存在，存在就不需要重新创建，不存在就创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath=realPath+"static/img/head/"+originalFilename;
        System.out.println(filePath);
        //上传文件的全路径
        String url =
                request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/head/" + originalFilename;
        System.out.println(url+"   url");
        if (new File(filePath).exists()){
            jsonModel.setData(url);
            System.out.println("文件存在");
            return jsonModel;
        }
        //转换成对应的文件存储，new File第一个参数是目录的路径，第二个参数是文件的完整名字
        multipartFile.transferTo(new File(file, originalFilename));

        jsonModel.setData(url);
        return jsonModel;

    }


    /**
     * 删除指定文件夹或文件
     * @param "path" 文件夹或文件路径
     * @return Boolean 删除成功返回true，删除失败返回false。
     */
    @GetMapping("/delete")
    public Boolean uploadCustomPathFile(@RequestParam("file")String file,@RequestParam("id")int id) throws FileNotFoundException {
        System.out.println(file+"id="+id);
        String path = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
        String realPath = path.substring(1) + "static" + file;
        boolean re=FileSystemUtils.deleteRecursively(new File(realPath));
        if (re){
            documentService.deleteByPrimaryKey(id);
        }
        return re;
    }

}