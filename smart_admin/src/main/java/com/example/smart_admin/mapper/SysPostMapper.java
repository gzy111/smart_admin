package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.domain.SysPost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysPostMapper {
    int deleteByPrimaryKey(Long postId);

    int insert(SysPost record);

    int insertSelective(SysPost record);

    List<SysPost> selectByPrimaryKey(SysPost record);

    int updateByPrimaryKeySelective(SysPost record);

    int updateByPrimaryKey(SysPost record);
}