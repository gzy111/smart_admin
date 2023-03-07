package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.domain.SysUserKey;
import com.example.smart_admin.mapper.SysUserMapper;
import com.example.smart_admin.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sysUserImpl implements sysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(SysUserKey key) {
        return sysUserMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(SysUserKey key) {
        return sysUserMapper.selectByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }
}
