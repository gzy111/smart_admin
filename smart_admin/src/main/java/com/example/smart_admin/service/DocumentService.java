package com.example.smart_admin.service;

import com.example.smart_admin.domain.Document;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DocumentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    PageInfo<Document> selectByPrimaryKey(Document document);

    int updateByPrimaryKeySelective(Document record);


}
