package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.mapper.SysDeptMapper;
import com.example.smart_admin.service.SysDeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptImpl implements SysDeptService {
    @Autowired
    SysDeptMapper sysDeptMapper;

    @Override
    public int deleteByPrimaryKey(Long deptId) {
        return sysDeptMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public int insert(SysDept record) {
        return sysDeptMapper.insert(record);
    }

    @Override
    public int insertSelective(SysDept record) {
        return sysDeptMapper.insertSelective(record);
    }

    @Override
    public PageInfo<SysDept> selectByPrimaryKey(SysDept record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<SysDept> list = (Page<SysDept>) sysDeptMapper.selectByPrimaryKey(record);
        PageInfo<SysDept> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<SysDept> selectByPrimaryKey() {
        return sysDeptMapper.selectByPrimaryKey();
    }

    @Override
    public int updateByPrimaryKeySelective(SysDept record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysDept record) {
        return 0;
    }
}
