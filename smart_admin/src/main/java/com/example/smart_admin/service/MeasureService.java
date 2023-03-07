package com.example.smart_admin.service;

import com.example.smart_admin.domain.Measure;

public interface MeasureService {
    int deleteByPrimaryKey(String measureCode);

    int insert(Measure record);

    int insertSelective(Measure record);

    Measure selectByPrimaryKey(String measureCode);

    int updateByPrimaryKeySelective(Measure record);

    int updateByPrimaryKeyWithBLOBs(Measure record);

    int updateByPrimaryKey(Measure record);
}
