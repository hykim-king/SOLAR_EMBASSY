package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Galaxy;
import com.community.solar_embassy.dto.Room;
import com.community.solar_embassy.mapper.RoomMapper;
import com.community.solar_embassy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<Room> selectRoomList() throws Exception {
        return roomMapper.selectRoomList();
    }

    @Override
    public List<Room> findAll(){
        return roomMapper.findAll();
    }


    @Override
    public List<Room> selectRoomListBySize(int size) throws Exception {
        return roomMapper.selectRoomListByBusiness(size);
    }

    @Override
    public int insertRoom(Room room) throws Exception {
        int lastRoomNo = roomMapper.lastRoom().getRoomNo();
        System.out.println(lastRoomNo);
        room.setRoomNo(lastRoomNo+1);
        int insert = roomMapper.insertRoom(room);
        return insert;
    }

    @Override
    public Room selectRoomDetail(int roomNo) throws Exception {
        roomMapper.updateViews(roomNo); // 조회수 증가
        return  roomMapper.selectRoomDetail(roomNo);
    }

    @Override
    public int updateRoom(Room room) throws Exception {
        return roomMapper.updateRoom(room);
    }

    @Override
    public int deleteRoom(int roomNo) throws Exception {
        return roomMapper.deleteRoom(roomNo);
    }

    @Override
    public List<Room> RoomListByBusiness(int roomNo) {
        return roomMapper.selectRoomListByBusiness(roomNo);
    }

    @Override
    public List<Room> RoomListByBusinessSize(int roomNo, int size) {
        return roomMapper.selectRoomListByBusinessSize(roomNo, size);
    }
}



