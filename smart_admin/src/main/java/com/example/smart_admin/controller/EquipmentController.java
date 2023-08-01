package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.service.EquipmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 设备管理
 *
 * */


@RestController
@RequestMapping("/Equipment")
@Api(tags = "Equipment", value = "设备接口")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @RequestMapping(value = "/equipmentSelectCode", method = RequestMethod.GET)
    public JsonModel<Equipment> selectCode(String code){
        Equipment equipment = equipmentService.selectByPrimaryKey(code);
        JsonModel<Equipment> jsonModel = new JsonModel<>();
        jsonModel.setData(equipment);
        jsonModel.setCode(200);
        return jsonModel;
    }


    @GetMapping("/equipmentSelectAll")
    public JsonModel<PageInfo<Equipment>> selectAllpageInfo(Equipment equipment){
        PageInfo<Equipment> equipments = equipmentService.selectByPrimaryKey(equipment);
        JsonModel<PageInfo<Equipment>> jsonModelList = new JsonModel<>();
        jsonModelList.setData(equipments);
        jsonModelList.setCode(200);
        return jsonModelList;
    }

    @RequestMapping("/equipmentDeleteByCode")
    public JsonModel<Integer> deleteByPrimaryKey( String code){
        int result = equipmentService.deleteByPrimaryKey(code);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }


    @PostMapping("/equipmentInsert")
    public JsonModel<Integer> insert( Equipment record){
        int result = equipmentService.insert(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }
    @PostMapping("/equipmentInsertSelective")
    public JsonModel<Integer>  insertSelective( @RequestBody Equipment record){
        //todo
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        record.setDate(new Date());
        //EquipmentCode由code 和id 组成
        int id = equipmentService.selectMaxId()+1;
        String code=record.getEquipmentType().split(",")[0];
        record.setId(id);
        record.setEquipmentCode(code+id);
        record.setEquipmentType(record.getEquipmentType().split(",")[1]);
        int result = equipmentService.insertSelective(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }


    @PutMapping("/equipmentUpdateBySelective")
    public JsonModel<Integer>  updateByPrimaryKeySelective( Equipment record){
        record.setDate(new Date());
        int result=equipmentService.updateByPrimaryKeySelective(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }
    @PutMapping("/equipmentPpdateByCode")
    public JsonModel<Integer>  updateByPrimaryKey(Equipment record){
        int result=equipmentService.updateByPrimaryKey(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }

}
