package com.example.smart_admin.mapper;


import com.example.smart_admin.domain.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    List<Statistics> listCount(String tableName, String groupByName, String whereName, String type);
    List<Statistics> listSum(String tableName, String groupByName, String whereName, String type,String sumName);
}
