package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Repair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairMapper {
    int deleteByPrimaryKey(String repairCode);

    int insert(Repair record);

    int insertSelective(Repair record);

    Repair selectByPrimaryKey(String repairCode);

    int updateByPrimaryKeySelective(Repair record);

    int updateByPrimaryKey(Repair record);
}