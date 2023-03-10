package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.mapper.EquipmentMapper;
import com.example.smart_admin.service.EquipmentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;


    @Override
    public int deleteByPrimaryKey(String equipmentCode) {
        return equipmentMapper.deleteByPrimaryKey(equipmentCode);
    }

    @Override
    public int insert(Equipment record) {
        return equipmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Equipment record) {
        return equipmentMapper.insertSelective(record);
    }

    @Override
    public Equipment selectByPrimaryKey(String equipmentCode) {
        return equipmentMapper.selectByPrimaryKey(equipmentCode);
    }

    @Override
    public PageInfo<Equipment> selectByPrimaryKey(Equipment equipment) {
        PageHelper.startPage(equipment.getPageNum(), equipment.getPageSize());
        Page<Equipment> list = (Page<Equipment>) equipmentMapper.selectByPrimaryKey(equipment);
        PageInfo<Equipment> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return equipmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return equipmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectMaxId() {
        return equipmentMapper.selectMaxId();
    }
}
