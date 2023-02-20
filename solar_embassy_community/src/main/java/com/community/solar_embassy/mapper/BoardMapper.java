package com.community.solar_embassy.mapper;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;
    int insertBoard(BoardDto board) throws Exception;
    void updateViews(int boardNo) throws Exception;
    List<BoardDto> selectBoardDetail(int boardNo) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int boardNo) throws Exception;
    int count(PagingDto board ) throws Exception;
}




