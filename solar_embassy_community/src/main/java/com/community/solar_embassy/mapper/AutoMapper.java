package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Auto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AutoMapper {
    List<Auto> selectAutoList(String comName);
    Auto selectByAutoName(String autoName);
    int insert(Auto auto);




}




