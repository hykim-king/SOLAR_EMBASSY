package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.PagingDto;

import java.util.List;

public interface BoardService  {

    List<BoardDto> selectBoardList() throws Exception;
    int insertBoard(BoardDto board) throws Exception;  // 게시글 작성 요청 처리
    BoardDto selectBoardDetail(int boardNo) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int boardNo) throws Exception;

}
