package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.SmartLookup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SmartLookupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartLookup record);

    int insertSelective(SmartLookup record);

    SmartLookup selectByPrimaryKey(Integer id);

    List<SmartLookup>  selectByPrimaryKey(String typeName);

    int updateByPrimaryKeySelective(SmartLookup record);

    int updateByPrimaryKey(SmartLookup record);
}