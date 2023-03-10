package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Warn;
import com.example.smart_admin.mapper.WarnMapper;
import com.example.smart_admin.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Warn selectByPrimaryKey(String warnCode) {
        return warnMapper.selectByPrimaryKey(warnCode);
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
}
