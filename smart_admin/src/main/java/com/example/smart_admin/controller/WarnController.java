package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Warn;
import com.example.smart_admin.service.WarnService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Warn")
public class WarnController {
    @Autowired
    WarnService warnService;


    @GetMapping("/Delete")
    public JsonModel<Integer> deleteByPrimaryKey(String warnCode) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(warnService.deleteByPrimaryKey(warnCode));
            jsonModel.setCode(200);
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;

    }

    @PostMapping("/Inset")
    public JsonModel<Integer> insertSelective(Warn record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
            String str =simpleDateFormat.format(new Date());
            record.setWarnCode("Warn"+str);
            jsonModel.setData(warnService.insertSelective(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }


    @PutMapping("/Update")
    public JsonModel<Integer> updateByPrimaryKeySelective(Warn record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(warnService.updateByPrimaryKeySelective(record));

            jsonModel.setCode(200);
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;

    }



    @GetMapping("/SelecetPageInfo")
    public JsonModel<PageInfo<Warn>> selectByPrimaryKey(Warn record) {
        JsonModel<PageInfo<Warn>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(warnService.selectByPrimaryKey(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;

    }

    @GetMapping("/SelectAll")
    public JsonModel<List<Warn>> selectByPrimaryKey() {
        JsonModel<List<Warn>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(warnService.selectByPrimaryKey());
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }
}
