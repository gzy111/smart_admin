package com.example.smart_admin.service;

import com.example.smart_admin.domain.Task;

public interface TastService {
    int deleteByPrimaryKey(String taskCode);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskCode);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}
