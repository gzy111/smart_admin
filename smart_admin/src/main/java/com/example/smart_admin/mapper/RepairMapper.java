package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Repair;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairMapper {
    int deleteByPrimaryKey(String repairCode);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(String repairCode);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKeyWithBLOBs(Repair record);

    int updateByPrimaryKey(Repair record);

    List<Repair> selectByPrimaryKey(Repair record);
}