package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.domain.SysUserKey;
import com.example.smart_admin.mapper.SysUserMapper;
import com.example.smart_admin.service.sysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SysUser> selectByPrimaryKey() {
        return sysUserMapper.selectByPrimaryKey();
    }

    @Override
    public PageInfo<SysUser> selectByPrimaryKey(SysUser record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<SysUser> list = (Page<SysUser>) sysUserMapper.selectByPrimaryKey(record);
        PageInfo<SysUser> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public SysUser login(Long userId, String password) {
        return sysUserMapper.login(userId,password);
    }

    @Override
    public SysUser selectUser(Long userId) {
        return sysUserMapper.selectUser(userId);
    }


}
