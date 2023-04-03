package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
    int deleteByPrimaryKey(String taskCode);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskCode);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKeyWithBLOBs(Task record);

    int updateByPrimaryKey(Task record);
}