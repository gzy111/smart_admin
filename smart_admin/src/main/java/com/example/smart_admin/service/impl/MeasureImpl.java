package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.domain.Measure;
import com.example.smart_admin.mapper.MeasureMapper;
import com.example.smart_admin.service.MeasureService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<Measure> selectByPrimaryKey(Measure measure) {
        PageHelper.startPage(measure.getPageNum(), measure.getPageSize());
        Page<Measure> list = (Page<Measure>) measureMapper.selectByPrimaryKey(measure);
        PageInfo<Measure> pageInfo = list.toPageInfo();
        return pageInfo ;
    }
}
