package com.example.smart_admin.service;

import com.example.smart_admin.domain.Warn;

public interface WarnService {
    int deleteByPrimaryKey(String warnCode);

    int insert(Warn record);

    int insertSelective(Warn record);

    Warn selectByPrimaryKey(String warnCode);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKeyWithBLOBs(Warn record);

    int updateByPrimaryKey(Warn record);
}
