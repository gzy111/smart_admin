package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Warn;
import com.example.smart_admin.mapper.WarnMapper;
import com.example.smart_admin.service.WarnService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarnImpl implements WarnService {

    @Autowired
    WarnMapper warnMapper;

    @Override
    public int deleteByPrimaryKey(String warnCode) {
        return warnMapper.deleteByPrimaryKey(warnCode);
    }

    @Override
    public int insert(Warn record) {
        return warnMapper.insert(record);
    }

    @Override
    public int insertSelective(Warn record) {
        return warnMapper.insertSelective(record);
    }


    @Override
    public int updateByPrimaryKeySelective(Warn record) {
        return warnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Warn record) {
        return warnMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Warn record) {
        return warnMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Warn> selectByPrimaryKey(Warn record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Warn> list = (Page<Warn>) warnMapper.selectByPrimaryKey(record);
        PageInfo<Warn> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<Warn> selectByPrimaryKey() {
        return warnMapper.selectByPrimaryKey();
    }
}
