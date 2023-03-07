package com.example.smart_admin.controller;

import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipment")
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

    @RequestMapping("/equipmentSelectAll")
    public JsonModel<List<Equipment>> selectAll(){
        List<Equipment> equipments = equipmentService.selectByPrimaryKey();
        JsonModel<List<Equipment>> jsonModelList = new JsonModel<>();
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
    public JsonModel<Integer>  insertSelective( Equipment record){
        int result = equipmentService.insertSelective(record);
        JsonModel<Integer> jsonModel = new JsonModel<>();
        jsonModel.setCode(200);
        jsonModel.setData(result);
        return jsonModel;
    }


    @PutMapping("/equipmentPpdateBySelective")
    public JsonModel<Integer>  updateByPrimaryKeySelective(Equipment record){
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
