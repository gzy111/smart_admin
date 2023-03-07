package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Repair;

public interface RepairMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}