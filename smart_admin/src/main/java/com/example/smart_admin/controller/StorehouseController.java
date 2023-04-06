package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Storehouse;
import com.example.smart_admin.service.StorehouseService;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Storehouse")
public class StorehouseController {

    @Autowired
    StorehouseService storehouseService;

    @GetMapping("/Delete")
    public JsonModel<Integer> deleteByPrimaryKey(Integer id) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(storehouseService.deleteByPrimaryKey(id));
            jsonModel.setCode(200);
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;

    }

    @PostMapping("/Inset")
    public JsonModel<Integer> insertSelective(Storehouse record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {

            jsonModel.setData(storehouseService.insertSelective(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }


    @PutMapping("/Update")
    public JsonModel<Integer> updateByPrimaryKeySelective(Storehouse record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(storehouseService.updateByPrimaryKeySelective(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;

    }



    @GetMapping("/SelecetPageInfo")
    public JsonModel<PageInfo<Storehouse>> selectByPrimaryKey(Storehouse record) {
        JsonModel<PageInfo<Storehouse>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(storehouseService.selectByPrimaryKey(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;

    }

    @GetMapping("/SelectAll")
    public JsonModel<List<Storehouse>> selectByPrimaryKey() {
        JsonModel<List<Storehouse>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(storehouseService.selectByPrimaryKey());
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }
}
