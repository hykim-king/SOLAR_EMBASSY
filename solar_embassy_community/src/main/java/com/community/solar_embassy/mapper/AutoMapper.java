package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Auto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AutoMapper {
     Auto selectByAutoNo(int autoNo);
     int insert(Auto auto);
}




