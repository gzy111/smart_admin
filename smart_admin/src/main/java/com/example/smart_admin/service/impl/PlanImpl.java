package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Plan;
import com.example.smart_admin.mapper.PlanMapper;
import com.example.smart_admin.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanImpl implements PlanService {

    @Autowired
    PlanMapper planMapper;

    @Override
    public int deleteByPrimaryKey(String planCode) {
        return planMapper.deleteByPrimaryKey(planCode);
    }

    @Override
    public int insert(Plan record) {
        return planMapper.insert(record);
    }

    @Override
    public int insertSelective(Plan record) {
        return planMapper.insertSelective(record);
    }

    @Override
    public Plan selectByPrimaryKey(String planCode) {
        return planMapper.selectByPrimaryKey(planCode);
    }

    @Override
    public int updateByPrimaryKeySelective(Plan record) {
        return planMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Plan record) {
        return planMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Plan record) {
        return planMapper.updateByPrimaryKey(record);
    }
}
