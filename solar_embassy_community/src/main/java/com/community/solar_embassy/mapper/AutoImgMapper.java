package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.AutoImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AutoImgMapper {
    int insert(AutoImg autoImg);
    AutoImg selectOne(int autoImgNo);
    int update(AutoImg autoImg);
    int delete(int autoImgNo);
    int resetImgNo(int autoImgNo);
    List<AutoImg> selectAutoList(int autoNo);

}




