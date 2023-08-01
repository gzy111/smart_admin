package com.example.smart_admin.service;



import com.example.smart_admin.domain.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Statistics> listCount(String tableName, String groupByName, String whereName, String type);
    List<Statistics> listSum(String tableName, String groupByName, String whereName, String type,String sumName);

}
