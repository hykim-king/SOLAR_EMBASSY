package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;

    int insertBoard(BoardDto board) throws Exception;
<<<<<<< HEAD
    void updateViews(int boardNo) throws Exception;
    List<BoardDto> selectBoardDetail(int boardNo) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int boardNo) throws Exception;
    int count(PagingDto board ) throws Exception;
=======

    void updateViews(int board_no) throws Exception;

    List<BoardDto> selectBoardDetail(int board_no) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int board_no) throws Exception;

    int count(BoardDto board ) throws Exception;

    List<BoardDto> selectBoardListBySize(int size);

    List<BoardDto> selectBoardListByGalaxy();


>>>>>>> 69a5ab68b59c6e2c9478a29653c95fb104023b62
}




