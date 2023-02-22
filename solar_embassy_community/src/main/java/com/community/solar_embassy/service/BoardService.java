package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.dto.PagingDto;

import java.util.List;

public interface BoardService  {

    List<BoardDto> selectBoardList() throws Exception;
    List<BoardDto> selectBoardListBySize(int size) throws Exception;
    int insertBoard(BoardDto board) throws Exception;  // 게시글 작성 요청 처리
    BoardDto selectBoardDetail(int boardNo) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
<<<<<<< HEAD
    void deleteBoard(int boardNo) throws Exception;

=======
    void deleteBoard(int board_id) throws Exception;

    List<BoardDto> boardListByGalaxy(int galaxyNo);
>>>>>>> 69a5ab68b59c6e2c9478a29653c95fb104023b62
}
