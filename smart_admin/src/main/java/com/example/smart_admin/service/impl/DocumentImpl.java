package com.example.smart_admin.service.impl;

import com.example.smart_admin.domain.Document;

import com.example.smart_admin.mapper.DocumentMapper;
import com.example.smart_admin.service.DocumentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentImpl implements DocumentService {

    @Autowired
    DocumentMapper documentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return documentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }

    @Override
    public int insertSelective(Document record) {
        return documentMapper.insertSelective(record);
    }

    @Override
    public Document selectByPrimaryKey(Integer id) {
        return documentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Document> selectByPrimaryKey(Document document) {
        PageHelper.startPage(document.getPageNum(), document.getPageSize());
        Page<Document> list = (Page<Document>) documentMapper.selectByPrimaryKey(document);
        PageInfo<Document> pageInfo = list.toPageInfo();
        return pageInfo;
    }

    @Override
    public int updateByPrimaryKeySelective(Document record) {
        return documentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int selectMaxId() {
        return documentMapper.selectMaxId();
    }


}
