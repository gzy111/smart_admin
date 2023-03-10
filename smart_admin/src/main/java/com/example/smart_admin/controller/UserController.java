package com.example.smart_admin.controller;


import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    sysUserService sysUserService;

    @RequestMapping("/selectAll")
    public JsonModel<List<SysUser>> selectByPrimaryKey() {
        JsonModel<List<SysUser>> jsonModel = new JsonModel<>();
        List<SysUser> list = new ArrayList<>();
        list = sysUserService.selectByPrimaryKey();
        jsonModel.setData(list);
        jsonModel.setCode(200);
        return jsonModel;
    }


}
