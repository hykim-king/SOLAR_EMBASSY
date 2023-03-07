package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardImg;
import com.community.solar_embassy.dto.RoomImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomImgMapper {
    RoomImg findByRoomNo(Integer roomNo);
}




