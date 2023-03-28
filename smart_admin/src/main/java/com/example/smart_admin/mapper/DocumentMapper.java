package com.example.smart_admin.mapper;

import com.example.smart_admin.domain.Document;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    List<Document> selectByPrimaryKey(Document document);

    int updateByPrimaryKeySelective(Document record);

}