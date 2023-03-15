package com.example.smart_admin.controller;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.service.SysDeptService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Dept")
public class SysDeptController {

    @Autowired
    SysDeptService sysDeptService;

    @RequestMapping("/SelectAll")
    public PageInfo<SysDept> selectByPrimaryKey(SysDept record) {
        return (PageInfo<SysDept>) sysDeptService.selectByPrimaryKey(record);
    }
}
