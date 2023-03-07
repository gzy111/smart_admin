package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.SmartLookup;

public interface SmartLookupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartLookup record);

    int insertSelective(SmartLookup record);

    SmartLookup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartLookup record);

    int updateByPrimaryKey(SmartLookup record);
}