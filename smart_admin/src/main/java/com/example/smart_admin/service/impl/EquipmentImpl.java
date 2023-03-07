package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.mapper.EquipmentMapper;
import com.example.smart_admin.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;


    @Override
    public int deleteByPrimaryKey(String equipmentCode) {
        return 0;
    }

    @Override
    public int insert(Equipment record) {
        return 0;
    }

    @Override
    public int insertSelective(Equipment record) {
        return 0;
    }

    @Override
    public Equipment selectByPrimaryKey(String equipmentCode) {
        return equipmentMapper.selectByPrimaryKey(equipmentCode);
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return 0;
    }
}
