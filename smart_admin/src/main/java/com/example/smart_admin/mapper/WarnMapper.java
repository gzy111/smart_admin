package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Warn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface WarnMapper {
    int deleteByPrimaryKey(String warnCode);

    int insert(Warn record);

    int insertSelective(Warn record);

    int updateByPrimaryKeySelective(Warn record);

    int updateByPrimaryKeyWithBLOBs(Warn record);

    int updateByPrimaryKey(Warn record);

    List<Warn> selectByPrimaryKey(Warn record);

    List<Warn> selectByPrimaryKey( );
}