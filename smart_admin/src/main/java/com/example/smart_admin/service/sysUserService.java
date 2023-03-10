package com.example.smart_admin.service;

import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.domain.SysUserKey;

import java.util.List;

public interface sysUserService {
    int deleteByPrimaryKey(SysUserKey key);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(SysUserKey key);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser>  selectByPrimaryKey();
}
