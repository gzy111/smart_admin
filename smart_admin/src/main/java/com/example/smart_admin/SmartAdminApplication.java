package com.example.smart_admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.smart_admin.mapper")
public class SmartAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartAdminApplication.class, args);
    }

}
