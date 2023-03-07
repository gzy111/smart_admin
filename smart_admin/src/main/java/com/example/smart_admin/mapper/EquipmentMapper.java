package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Equipment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}