package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.PagingDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;
    List<BoardDto> selectBoardListBySize(int size) throws Exception;
    int insertBoard(BoardDto board) throws Exception;  // 게시글 작성 요청 처리
    BoardDto selectBoardDetail(int boardNo) throws Exception;
    int updateBoard(BoardDto board) throws Exception;
    int deleteBoard(int boardNo) throws Exception;

    List<BoardDto> boardListByGalaxy(int galaxyNo);
    List<BoardDto> boardListByGalaxySize(int galaxyNo,int size);

    List<BoardDto> hotList(int endNo);
    int lastNo();

    List<BoardDto> BoardListByUserId(String userId);
}