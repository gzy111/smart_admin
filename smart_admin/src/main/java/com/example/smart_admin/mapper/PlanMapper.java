package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Plan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
    int deleteByPrimaryKey(String planCode);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(String planCode);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKeyWithBLOBs(Plan record);

    int updateByPrimaryKey(Plan record);
}