package com.example.smart_admin.controller;


import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.domain.Measure;
import com.example.smart_admin.service.MeasureService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * 数据采集管理
 * */
@RestController
@RequestMapping("/Measure")
public class MeasureController {

    @Autowired
    MeasureService measureService;



    @GetMapping("/selectAllpageInfo")
    public JsonModel<PageInfo<Measure>> selectAllpageInfo(Measure Measure){
        PageInfo<Measure> measures = measureService.selectByPrimaryKey(Measure);
        JsonModel<PageInfo<Measure>> jsonModelList = new JsonModel<>();
        jsonModelList.setData(measures);
        jsonModelList.setCode(200);
        return jsonModelList;
    }



    @GetMapping("/deleteByPrimaryKey")
    public JsonModel<Integer> deleteByPrimaryKey(String measureCode) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("删除成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.deleteByPrimaryKey(measureCode));
        return jsonModel;
    }


    @PostMapping ("/insert")
    public JsonModel<Integer> insert(Measure record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("添加成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.insert(record));
        return jsonModel;
    }

    @PostMapping ("/insertSelective")
    public JsonModel<Integer> insertSelective(Measure record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("添加成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.insertSelective(record));
        return jsonModel;
    }

    @GetMapping("/selectByPrimaryKey")
    public JsonModel<Measure> selectByPrimaryKey(String measureCode) {
        JsonModel<Measure> jsonModel = new JsonModel<>();
        jsonModel.setMsg("查询成功");
        jsonModel.setCode(200);
        Measure measure = measureService.selectByPrimaryKey(measureCode);
        jsonModel.setData(measure);
        return jsonModel;
    }

    @PutMapping("/updateByPrimaryKeySelective")
    public JsonModel<Integer> updateByPrimaryKeySelective(Measure record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("更新成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.updateByPrimaryKeySelective(record));
        return jsonModel;
    }

    @PutMapping("/updateByPrimaryKeyWithBLOBs")
    public JsonModel<Integer> updateByPrimaryKeyWithBLOBs(Measure record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("更新成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.updateByPrimaryKeyWithBLOBs(record));
        return jsonModel;
    }

    @PutMapping("/updateByPrimaryKey")
    public JsonModel<Integer> updateByPrimaryKey(Measure record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setMsg("更新成功");
        jsonModel.setCode(200);
        jsonModel.setData(measureService.updateByPrimaryKey(record));
        return jsonModel;
    }
}
