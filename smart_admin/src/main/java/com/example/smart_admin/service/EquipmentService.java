package com.example.smart_admin.service;

import com.example.smart_admin.domain.Equipment;

import java.util.List;

public interface EquipmentService {
    int deleteByPrimaryKey(String equipmentCode);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(String equipmentCode);
    List<Equipment> selectByPrimaryKey( );
    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

}
