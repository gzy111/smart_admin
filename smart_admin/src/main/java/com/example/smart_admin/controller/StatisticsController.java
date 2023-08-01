package com.example.smart_admin.controller;


import com.example.smart_admin.domain.Statistics;
import com.example.smart_admin.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/ListCount")
    public List<Statistics> listCount(String tableName, String groupByName, String whereName, String type){
        System.out.println(tableName+groupByName);
        List<Statistics> statisticsList =statisticsService.listCount(tableName,groupByName,whereName,type);
        return statisticsList;
    }

    @GetMapping("/ListSum")
    public List<Statistics> listSum(String tableName, String groupByName, String whereName, String type,String sumName){
        System.out.println(tableName+groupByName);
        List<Statistics> statisticsList =statisticsService.listSum(tableName,groupByName,whereName,type,sumName);
        return statisticsList;
    }

}
