package com.example.smart_admin.service;

import com.example.smart_admin.domain.Equipment;

public interface EquipmentService {
    int deleteByPrimaryKey(String equipmentCode);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(String equipmentCode);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

}
