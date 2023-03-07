package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.Galaxy;
import com.community.solar_embassy.dto.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<Room> selectRoomList() throws Exception;
    int insertRoom(Room room) throws Exception;
    void updateViews(int roomNo) throws Exception;
    Room selectRoomDetail(int roomNo) throws Exception;
    int updateRoom(Room room) throws Exception;
    int deleteRoom(int roomNo) throws Exception;
    List<Room> selectBoardListBySize(int size);

    List<Room> selectRoomListByBusiness(int roomNo);

    List<Room> selectRoomListByBusinessSize(int roomNo, int size);

    List<Room> findAll();

    Room lastRoom();
}





