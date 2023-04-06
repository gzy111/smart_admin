package com.example.smart_admin.controller;


import com.example.smart_admin.Utils.JsonModel;
import com.example.smart_admin.domain.Task;
import com.example.smart_admin.service.TaskService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/Delete")
    public JsonModel<Integer> deleteByPrimaryKey(String taskCode) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(taskService.deleteByPrimaryKey(taskCode));
            jsonModel.setCode(200);
            jsonModel.setMsg("删除成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("删除失败");
        }
        return jsonModel;

    }

    @PostMapping("/Inset")
    public JsonModel<Integer> insertSelective(Task record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
            String str =simpleDateFormat.format(new Date());
            record.setTaskCode("Task"+str);
            record.setTaskTime(new Date());
            record.setData("createTime:"+new Date());
            jsonModel.setData(taskService.insertSelective(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("添加成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("添加失败");
        }
        return jsonModel;
    }


    @PutMapping("/Update")
    public JsonModel<Integer> updateByPrimaryKeySelective(Task record) {
        JsonModel<Integer> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(taskService.updateByPrimaryKeySelective(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("更新成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("更新失败");
        }
        return jsonModel;

    }



    @GetMapping("/SelecetPageInfo")
    public JsonModel<PageInfo<Task> > selectByPrimaryKey(Task record) {
        JsonModel<PageInfo<Task>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(taskService.selectByPrimaryKey(record));
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;

    }

    @GetMapping("/SelectAll")
    public JsonModel<List<Task>> selectByPrimaryKey() {
        JsonModel<List<Task>> jsonModel = new JsonModel<>();
        try {
            jsonModel.setData(taskService.selectByPrimaryKey());
            jsonModel.setCode(200);
            jsonModel.setMsg("查询成功");
        }catch (Exception e){
            jsonModel.setCode(404);
            jsonModel.setMsg("查询失败");
        }
        return jsonModel;
    }
}
