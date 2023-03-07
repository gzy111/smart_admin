package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Measure;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeasureMapper {
    int deleteByPrimaryKey(String measureCode);

    int insert(Measure record);

    int insertSelective(Measure record);

    Measure selectByPrimaryKey(String measureCode);

    int updateByPrimaryKeySelective(Measure record);

    int updateByPrimaryKeyWithBLOBs(Measure record);

    int updateByPrimaryKey(Measure record);
}