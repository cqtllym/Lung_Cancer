package com.lym.lung_cancer_server.mapper;

import com.lym.lung_cancer_server.entity.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResultMapper {
    @Select("select * from patient")
    List<Result> selectResult();
}