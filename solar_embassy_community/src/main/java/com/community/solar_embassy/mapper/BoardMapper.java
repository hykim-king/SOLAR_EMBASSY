package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;

    int insertBoard(BoardDto board) throws Exception;

    void updateViews(int board_no) throws Exception;

    BoardDto selectBoardDetail(int boardNo) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int board_no) throws Exception;


    int count(BoardDto board ) throws Exception;

    List<BoardDto> selectBoardListBySize(int size);

    List<BoardDto> selectBoardListByGalaxy(int galaxyNo);


}



