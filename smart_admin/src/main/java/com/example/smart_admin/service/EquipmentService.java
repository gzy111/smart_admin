package com.example.smart_admin.service;

import com.example.smart_admin.domain.Equipment;
import com.github.pagehelper.PageInfo;

public interface EquipmentService {
    int deleteByPrimaryKey(String equipmentCode);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(String equipmentCode);
    PageInfo<Equipment> selectByPrimaryKey(Equipment equipment);
    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

}
