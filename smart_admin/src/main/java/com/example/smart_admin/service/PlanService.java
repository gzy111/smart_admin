package com.example.smart_admin.service;

import com.example.smart_admin.domain.Plan;

public interface PlanService {

    int deleteByPrimaryKey(String planCode);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(String planCode);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKeyWithBLOBs(Plan record);

    int updateByPrimaryKey(Plan record);



}
