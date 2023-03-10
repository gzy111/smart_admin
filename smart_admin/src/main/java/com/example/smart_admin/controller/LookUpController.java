package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.SmartLookup;
import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.mapper.SmartLookupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/LookUp")
public class LookUpController {

    @Autowired
    SmartLookupMapper smartLookupMapper;

    @RequestMapping("/selectAll")
    public JsonModel<List<SmartLookup>> selectByPrimaryKey(String typeName) {
        System.out.println(typeName);
        JsonModel<List<SmartLookup>> jsonModel = new JsonModel<>();
        List<SmartLookup> list = new ArrayList<>();
        list = smartLookupMapper.selectByPrimaryKey(typeName);
        jsonModel.setData(list);
        jsonModel.setCode(200);
        return jsonModel;
    }
}
