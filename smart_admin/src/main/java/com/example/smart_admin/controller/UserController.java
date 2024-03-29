package com.example.smart_admin.controller;


import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.domain.SysUserKey;
import com.example.smart_admin.service.sysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    sysUserService sysUserService;

    @GetMapping("/selectAll")
    public JsonModel<List<SysUser>> selectByPrimaryKey() {
        JsonModel<List<SysUser>> jsonModel = new JsonModel<>();
        List<SysUser> list = new ArrayList<>();
        list = sysUserService.selectByPrimaryKey();
        jsonModel.setData(list);
        jsonModel.setCode(200);
        return jsonModel;
    }


    @GetMapping("/selectPage")
    public PageInfo<SysUser> select( SysUser sysUser){
        return sysUserService.selectByPrimaryKey(sysUser);
    }

    @GetMapping("/DeleteUser")
    public JsonModel<Integer> deleteUser(SysUserKey key){
        int result=sysUserService.deleteByPrimaryKey(key);
        JsonModel<Integer> jsonModel =new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setMsg("删除成功");
        jsonModel.setData(result);
        return jsonModel;
    }


    @PutMapping("/UpdateUser")
    public JsonModel<Integer> updateUser(SysUser user){
        System.out.println(user.toString());

        System.out.println(user.getUserId());
        int result=sysUserService.updateByPrimaryKeySelective(user);
        System.out.println(result);
        JsonModel<Integer> jsonModel =new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setMsg("更新成功");
        jsonModel.setData(result);
        return jsonModel;
    }


    @PostMapping("/InsertUser")
    public JsonModel<Integer> insertSelective(@RequestBody  SysUser record){
        record.setCreateTime(new Date());
        System.out.println(record.toString());
        record.setId(1);
        int result=sysUserService.insertSelective(record);
        JsonModel<Integer> jsonModel =new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setMsg("添加成功");
        jsonModel.setData(result);
        return jsonModel;
    }

}
