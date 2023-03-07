package com.example.smart_admin.controller;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public Equipment selectTest(Integer id){
        Equipment equipment = equipmentService.selectByPrimaryKey(id);
        return equipment;
    }

}
