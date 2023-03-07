package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Warn;

public interface WarnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warn record);

    int insertSelective(Warn record);

    Warn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKeyWithBLOBs(Warn record);

    int updateByPrimaryKey(Warn record);
}