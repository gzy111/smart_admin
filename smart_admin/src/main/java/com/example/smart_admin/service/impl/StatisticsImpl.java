package com.example.smart_admin.service.impl;



import com.example.smart_admin.domain.Statistics;
import com.example.smart_admin.mapper.StatisticsMapper;
import com.example.smart_admin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsImpl implements StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Override
    public List<Statistics> listCount(String tableName, String groupByName, String whereName, String type) {
        return statisticsMapper.listCount(tableName,groupByName,whereName,type);
    }

    @Override
    public List<Statistics> listSum(String tableName, String groupByName, String whereName, String type,
                                    String sumName) {
        return statisticsMapper.listSum(tableName,groupByName,whereName,type,sumName);
    }
}
