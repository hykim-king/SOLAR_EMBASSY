package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.RoomImg;
import com.community.solar_embassy.mapper.RoomImgMapper;
import com.community.solar_embassy.service.RoomImgService;
import org.springframework.stereotype.Service;

@Service
public class RoomImgServiceImpl
        implements RoomImgService {

    RoomImgMapper roomImgMapper;


    public  RoomImgServiceImpl(RoomImgMapper roomImgMapper){
        this.roomImgMapper = roomImgMapper;
    }


    @Override
    public RoomImg selectOne(Integer roomNo) {
        return roomImgMapper.findByRoomNo(roomNo);
    }
}




