package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Plan;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKeyWithBLOBs(Plan record);

    int updateByPrimaryKey(Plan record);
}