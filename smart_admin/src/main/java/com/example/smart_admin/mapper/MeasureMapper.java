package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Measure;

public interface MeasureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Measure record);

    int insertSelective(Measure record);

    Measure selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Measure record);

    int updateByPrimaryKeyWithBLOBs(Measure record);

    int updateByPrimaryKey(Measure record);
}