package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Room;

import java.util.List;

public interface RoomService {
    List<Room> selectRoomList() throws Exception;
    List<Room> findAll ();
    List<Room> selectRoomListBySize(int size) throws Exception;
    int insertRoom(Room room) throws Exception;  // 게시글 작성 요청 처리
    Room selectRoomDetail(int roomNo) throws Exception;
    int updateRoom(Room room) throws Exception;
    int deleteRoom(int roomNo) throws Exception;

    List<Room> RoomListByBusiness(int roomNo);
    List<Room> RoomListByBusinessSize(int roomNo,int size);


}