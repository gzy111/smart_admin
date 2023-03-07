package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Measure;
import com.example.smart_admin.mapper.MeasureMapper;
import com.example.smart_admin.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasureImpl implements MeasureService {
//    @Autowired
//    MeasureMapper measureMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Measure record) {
        return 0;
    }

    @Override
    public int insertSelective(Measure record) {
        return 0;
    }

    @Override
    public Measure selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Measure record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Measure record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Measure record) {
        return 0;
    }
}
