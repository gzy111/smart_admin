package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Storehouse;
import com.example.smart_admin.domain.Warn;
import com.example.smart_admin.mapper.StorehouseMapper;
import com.example.smart_admin.service.StorehouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorehouseImpl implements StorehouseService {

    @Autowired
    StorehouseMapper storehouseMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return storehouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Storehouse record) {
        return storehouseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Storehouse record) {
        return storehouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<Storehouse> selectByPrimaryKey(Storehouse record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Storehouse> list = (Page<Storehouse>) storehouseMapper.selectByPrimaryKey(record);
        PageInfo<Storehouse> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<Storehouse> selectByPrimaryKey() {
        return storehouseMapper.selectByPrimaryKey();
    }
}
