package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Storehouse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);
}