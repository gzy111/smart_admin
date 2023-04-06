package com.example.smart_admin.service;

import com.example.smart_admin.domain.Warn;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WarnService {
    int deleteByPrimaryKey(String warnCode);

    int insert(Warn record);

    int insertSelective(Warn record);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKeyWithBLOBs(Warn record);

    int updateByPrimaryKey(Warn record);

    PageInfo<Warn> selectByPrimaryKey(Warn record);

    List<Warn> selectByPrimaryKey();

}
