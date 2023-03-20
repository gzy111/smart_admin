package com.example.smart_admin.controller;

import com.example.smart_admin.domain.SysDept;
import com.example.smart_admin.domain.SysPost;
import com.example.smart_admin.domain.TreeSelect;
import com.example.smart_admin.service.SysDeptService;
import com.example.smart_admin.service.SysPostService;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Dept")
public class SysDeptController {

    @Autowired
    SysDeptService sysDeptService;

    @Autowired
    SysPostService sysPostService;

    @RequestMapping("/SelectPage")
    public PageInfo<SysDept> selectByPrimaryKey(SysDept record) {
        return  sysDeptService.selectByPrimaryKey(record);
    }

    @RequestMapping("/SelectAll")
    public List<SysDept> selectByPrimaryKey() {
        return  sysDeptService.selectByPrimaryKey();
    }



    @RequestMapping("/TreeSelect")
    public List treeSelects(){
        List lists =new ArrayList<>();
        List<SysDept> sysDeptList=sysDeptService.selectByPrimaryKey();
        for (SysDept dept:sysDeptList) {
            List<TreeSelect> list=new ArrayList<>();
            TreeSelect treeSelect = new TreeSelect();
            SysPost post = new SysPost();
            post.setDeptId(dept.getDeptId());
            PageInfo<SysPost> postList =  sysPostService.selectByPrimaryKey(post);
//            System.out.println(postList.getList().toArray().toString());
            for (SysPost post1 :postList.getList()){
                TreeSelect tree = new TreeSelect();
                tree.setId(post1.getPostCode());
                tree.setLabel(post1.getPostName());
                list.add(tree);
                System.out.println(post1);
            }
            System.out.println(dept.getDeptName()+"----------------------");
            treeSelect.setId(String.valueOf(dept.getDeptId()));
            treeSelect.setLabel(dept.getDeptName());
            treeSelect.setChildren(list);
            lists.add(treeSelect);
        }

        return lists;
    }

}
