package com.example.smart_admin.service;

import com.example.smart_admin.domain.SysDept;
import com.github.pagehelper.PageInfo;

public interface SysDeptService {
    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    PageInfo<SysDept> selectByPrimaryKey(SysDept record);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}
