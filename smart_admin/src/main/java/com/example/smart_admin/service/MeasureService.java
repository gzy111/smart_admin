package com.example.smart_admin.service;

import com.example.smart_admin.domain.Measure;

public interface MeasureService {
    int deleteByPrimaryKey(Integer id);

    int insert(Measure record);

    int insertSelective(Measure record);

    Measure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Measure record);

    int updateByPrimaryKeyWithBLOBs(Measure record);

    int updateByPrimaryKey(Measure record);
}
