package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface PlayerMapper {

    @Select("select * from player")
    List<Map<String,Object>> queryAllPlayer();

}
