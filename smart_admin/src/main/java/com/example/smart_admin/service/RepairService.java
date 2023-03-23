package com.example.smart_admin.service;

import com.example.smart_admin.domain.Repair;
import com.github.pagehelper.PageInfo;

public interface RepairService {
    int deleteByPrimaryKey(String repairCode);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(String repairCode);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKeyWithBLOBs(Repair record);

    int updateByPrimaryKey(Repair record);

    PageInfo<Repair> selectByPrimaryKey(Repair record);
}
