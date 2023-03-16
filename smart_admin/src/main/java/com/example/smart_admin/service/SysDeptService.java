package com.example.smart_admin.service;

import com.example.smart_admin.domain.SysDept;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysDeptService {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    PageInfo<SysDept> selectByPrimaryKey(SysDept record);
    List<SysDept> selectByPrimaryKey();

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}
