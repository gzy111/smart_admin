package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Equipment;
import com.example.smart_admin.domain.Repair;
import com.example.smart_admin.domain.SysPost;
import com.example.smart_admin.mapper.RepairMapper;
import com.example.smart_admin.service.RepairService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairImpl  implements RepairService {


    @Autowired
    RepairMapper repairMapper;

    @Override
    public int deleteByPrimaryKey(String repairCode) {
        return repairMapper.deleteByPrimaryKey(repairCode);
    }

    @Override
    public int insert(Repair record) {
        return repairMapper.insert(record);
    }

    @Override
    public int insertSelective(Repair record) {
        return repairMapper.insert(record);
    }

    @Override
    public Repair selectByPrimaryKey(String repairCode) {
        return repairMapper.selectByPrimaryKey(repairCode);
    }

    @Override
    public int updateByPrimaryKeySelective(Repair record) {
        return repairMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Repair record) {
        return repairMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Repair record) {
        return repairMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Repair> selectByPrimaryKey(Repair record) {
        PageHelper.startPage(record.getPageNum(), record.getPageSize());
        Page<Repair> list = (Page<Repair>) repairMapper.selectByPrimaryKey(record);
        PageInfo<Repair> pageInfo = list.toPageInfo();


        return pageInfo;
    }
}
