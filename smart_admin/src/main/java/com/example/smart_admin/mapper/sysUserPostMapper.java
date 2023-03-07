package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.sysUserPost;
import com.example.smart_admin.domain.sysUserPostKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface sysUserPostMapper {
    int deleteByPrimaryKey(sysUserPostKey key);

    int insert(sysUserPost record);

    int insertSelective(sysUserPost record);

    sysUserPost selectByPrimaryKey(sysUserPostKey key);

    int updateByPrimaryKeySelective(sysUserPost record);

    int updateByPrimaryKey(sysUserPost record);
}