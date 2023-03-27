package com.example.smart_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/File")
public class FileUploadController {

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
        return url;

    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response, @RequestParam("filename") String fileName) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found!");
            return;
        }

        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"");

        try (InputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

}
