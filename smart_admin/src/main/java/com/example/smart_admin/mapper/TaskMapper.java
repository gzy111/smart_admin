package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TaskMapper {
    int deleteByPrimaryKey(String taskCode);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByPrimaryKey(Task record);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> selectByPrimaryKey();

}