package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.SmartLookup;
import com.example.smart_admin.mapper.SmartLookupMapper;
import com.example.smart_admin.service.SmartLookupService;
import org.springframework.stereotype.Service;

@Service
public class SmartLookupImpl implements SmartLookupService {

    SmartLookupMapper smartLookupMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return smartLookupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SmartLookup record) {
        return smartLookupMapper.insert(record);
    }

    @Override
    public int insertSelective(SmartLookup record) {
        return smartLookupMapper.insertSelective(record);
    }

    @Override
    public SmartLookup selectByPrimaryKey(Integer id) {
        return smartLookupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SmartLookup record) {
        return smartLookupMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SmartLookup record) {
        return smartLookupMapper.updateByPrimaryKey(record);
    }
}
