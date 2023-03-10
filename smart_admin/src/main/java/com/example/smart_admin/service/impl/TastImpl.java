package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Task;
import com.example.smart_admin.mapper.TaskMapper;
import com.example.smart_admin.service.TastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TastImpl implements TastService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public int deleteByPrimaryKey(String taskCode) {
        return taskMapper.deleteByPrimaryKey(taskCode);
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public int insertSelective(Task record) {
        return taskMapper.insertSelective(record);
    }

    @Override
    public Task selectByPrimaryKey(String taskCode) {
        return taskMapper.selectByPrimaryKey(taskCode);
    }

    @Override
    public int updateByPrimaryKeySelective(Task record) {
        return taskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }
}
