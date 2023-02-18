package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.AutoData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AutoDataMapper {
    List<AutoData> selectAutoDataDetail(int dataNo) throws Exception;
}
