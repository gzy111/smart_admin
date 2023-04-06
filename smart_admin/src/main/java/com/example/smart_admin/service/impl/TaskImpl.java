package com.example.smart_admin.service.impl;


import com.example.smart_admin.domain.Task;
import com.example.smart_admin.mapper.TaskMapper;
import com.example.smart_admin.service.TaskService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskImpl implements TaskService {
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
    public int updateByPrimaryKeySelective(Task record) {
        return taskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Task record) {
        return taskMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Task> selectByPrimaryKey(Task record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Task> list = (Page<Task>) taskMapper.selectByPrimaryKey(record);
        PageInfo<Task> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public List<Task> selectByPrimaryKey() {
        return taskMapper.selectByPrimaryKey();
    }



}
