package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardImgMapper {

    BoardImg findByBoardNo(Integer boardNo);
}



