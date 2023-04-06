package com.example.smart_admin.service;

import com.example.smart_admin.domain.Storehouse;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface StorehouseService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Storehouse record);

    int updateByPrimaryKeySelective(Storehouse record);

    PageInfo<Storehouse> selectByPrimaryKey(Storehouse record);

    List<Storehouse> selectByPrimaryKey( );
}
