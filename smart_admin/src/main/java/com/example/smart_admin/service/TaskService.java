package com.example.smart_admin.service;

import com.example.smart_admin.domain.Task;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskService {
    int deleteByPrimaryKey(String taskCode);

    int insert(Task record);

    int insertSelective(Task record);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    PageInfo<Task> selectByPrimaryKey(Task record);

    List<Task> selectByPrimaryKey();


}
