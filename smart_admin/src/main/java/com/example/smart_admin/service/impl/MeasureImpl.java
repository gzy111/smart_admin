package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Measure;
import com.example.smart_admin.mapper.MeasureMapper;
import com.example.smart_admin.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasureImpl implements MeasureService {
    @Autowired
    MeasureMapper measureMapper;

    @Override
    public int deleteByPrimaryKey(String measureCode) {
        return measureMapper.deleteByPrimaryKey(measureCode);
    }

    @Override
    public int insert(Measure record) {
        return measureMapper.insert(record);
    }

    @Override
    public int insertSelective(Measure record) {
        return measureMapper.insertSelective(record);
    }

    @Override
    public Measure selectByPrimaryKey(String measureCode) {
        return measureMapper.selectByPrimaryKey(measureCode);
    }

    @Override
    public int updateByPrimaryKeySelective(Measure record) {
        return measureMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Measure record) {
        return measureMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Measure record) {
        return measureMapper.updateByPrimaryKey(record);
    }
}
