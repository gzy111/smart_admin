package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Storehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);

    List<Storehouse> selectByPrimaryKey(Storehouse record);

    List<Storehouse> selectByPrimaryKey( );
}