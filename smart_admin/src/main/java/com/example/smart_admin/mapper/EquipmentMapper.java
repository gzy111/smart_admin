package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Equipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentMapper {
    int deleteByPrimaryKey(String equipmentCode);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(String equipmentCode);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}