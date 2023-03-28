package com.example.smart_admin.test;


import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) throws FileNotFoundException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        System.out.println(dateString);



        String realPath = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX).getPath();
        System.out.println(ResourceUtils.CLASSPATH_URL_PREFIX);
        System.out.println(ResourceUtils.getURL(ResourceUtils.FILE_URL_PREFIX));
        System.out.println(realPath);

    }
}
