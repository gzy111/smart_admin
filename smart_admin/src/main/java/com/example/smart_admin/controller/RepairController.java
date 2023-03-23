package com.example.smart_admin.controller;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.domain.Repair;
import com.example.smart_admin.mapper.RepairMapper;
import com.example.smart_admin.service.RepairService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Repair")
public class RepairController {


    @Autowired
    RepairService repairService;

    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(String repairCode) {
        return repairService.deleteByPrimaryKey(repairCode);
    }

    @RequestMapping("/insert")
    public int insert(Repair record) {
        return repairService.insert(record);
    }

    @RequestMapping("/insertSelective")
    public int insertSelective(@RequestBody Repair record) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
        String str =simpleDateFormat.format(date);
        record.setCreateTime(date);
        record.setRepairCode(record.getEquipmentCode()+"-"+str);
        return repairService.insert(record);
    }

    @RequestMapping("/selectByPrimaryKey")
    public Repair selectByPrimaryKey(String repairCode) {
        return repairService.selectByPrimaryKey(repairCode);
    }
    @RequestMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(Repair record) {
        return repairService.updateByPrimaryKeySelective(record);
    }
    @RequestMapping("/updateByPrimaryKeyWithBLOBs")
    public int updateByPrimaryKeyWithBLOBs(Repair record) {
        return repairService.updateByPrimaryKeyWithBLOBs(record);
    }
    @RequestMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(Repair record) {
        return repairService.updateByPrimaryKey(record);
    }

    @RequestMapping("/selectPage")
    public PageInfo<Repair> selectByPrimaryKey(Repair record){
        PageInfo<Repair> pageInfo =repairService.selectByPrimaryKey(record);
        return pageInfo;
    }
}
