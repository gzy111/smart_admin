package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.domain.SysUserKey;

public interface SysUserMapper {
    int deleteByPrimaryKey(SysUserKey key);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(SysUserKey key);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}