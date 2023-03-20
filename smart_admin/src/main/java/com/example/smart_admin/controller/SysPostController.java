package com.example.smart_admin.controller;



import com.example.smart_admin.domain.SysPost;
import com.example.smart_admin.service.SysPostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class SysPostController {
    @Autowired
    SysPostService sysPostService;

    @RequestMapping("/SelectPageAll")
    public PageInfo<SysPost> selectByPrimaryKey(SysPost record) {
        return sysPostService.selectByPrimaryKey(record);
    }
    @RequestMapping("/SelectAll")
    public List<SysPost> selectByPrimaryKey(){
        return sysPostService.selectByPrimaryKey();
    }


}
