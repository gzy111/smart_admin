package com.example.smart_admin.service;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.domain.SysPost;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SysPostService {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    PageInfo<SysPost> selectByPrimaryKey(SysPost record);

    List<SysPost> selectByPrimaryKey();

    int updateByPrimaryKeySelective(SysPost record);

    int updateByPrimaryKey(SysPost record);

    int selectMaxId();
}
