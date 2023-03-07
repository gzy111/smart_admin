package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.mapper.EquipmentMapper;
import com.example.smart_admin.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Equipment> selectByPrimaryKey() {
        return equipmentMapper.selectByPrimaryKey();
    }

    @Override
    public int updateByPrimaryKeySelective(Equipment record) {
        return equipmentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Equipment record) {
        return equipmentMapper.updateByPrimaryKey(record);
    }
}
