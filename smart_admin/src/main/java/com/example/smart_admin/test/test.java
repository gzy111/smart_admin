package com.example.smart_admin.test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        System.out.println(dateString);
    }
}
