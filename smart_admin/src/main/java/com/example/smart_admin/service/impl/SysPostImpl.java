package com.example.smart_admin.service.impl;


import com.example.smart_admin.domain.SysPost;
import com.example.smart_admin.mapper.SysPostMapper;
import com.example.smart_admin.service.SysPostService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPostImpl implements SysPostService {

    @Autowired
    SysPostMapper sysPostMapper;

    @Override
    public int deleteByPrimaryKey(Long postId) {
        return sysPostMapper.deleteByPrimaryKey(postId);
    }

    @Override
    public int insert(SysPost record) {
        return sysPostMapper.insert(record);
    }

    @Override
    public int insertSelective(SysPost record) {
        return sysPostMapper.insertSelective(record);
    }

    @Override
    public PageInfo<SysPost> selectByPrimaryKey(SysPost record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<SysPost> list = (Page<SysPost>) sysPostMapper.selectByPrimaryKey(record);
        PageInfo<SysPost> pageInfo = list.toPageInfo();

        return pageInfo;
    }

    @Override
    public List<SysPost> selectByPrimaryKey() {
        return sysPostMapper.selectByPrimaryKey();
    }

    @Override
    public int updateByPrimaryKeySelective(SysPost record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysPost record) {
        return 0;
    }
}
