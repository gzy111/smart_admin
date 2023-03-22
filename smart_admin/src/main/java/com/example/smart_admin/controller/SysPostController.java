package com.example.smart_admin.controller;



import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.SysPost;
import com.example.smart_admin.service.SysPostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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



    @PutMapping("/UpdateBySelective")
    public JsonModel<Integer> updateByPrimaryKeySelective(SysPost record){
        record.setUpdateTime(new Date());
        long deptId = record.getDeptId();
        record.setPostCode("P"+deptId+record.getPostId());
        int result=sysPostService.updateByPrimaryKeySelective(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }


    @PostMapping("/InsertSelective")
    public JsonModel<Integer>  insertSelective(@RequestBody  SysPost record){
        record.setCreateTime(new Date());
        int id=sysPostService.selectMaxId()+1;
        long deptId = record.getDeptId();
        record.setPostCode("P"+deptId+id);
        int result = sysPostService.insertSelective(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }


    @RequestMapping("/DeleteByCode")
    public JsonModel<Integer> deleteByPrimaryKey( long code){
        int result = sysPostService.deleteByPrimaryKey(code);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }



}
