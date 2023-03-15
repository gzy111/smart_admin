package com.example.smart_admin.service;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.domain.SysPost;
import com.github.pagehelper.PageInfo;

public interface SysPostService {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    PageInfo<SysPost> selectByPrimaryKey(SysPost record);

    int updateByPrimaryKeySelective(SysPost record);

    int updateByPrimaryKey(SysPost record);
}
