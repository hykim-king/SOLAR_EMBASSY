package com.community.solar_embassy.mapper;


import com.community.solar_embassy.dto.Galaxy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GalaxyMapper {
    Galaxy findGalaxy(int galaxyNo);

}




