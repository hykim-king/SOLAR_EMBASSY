package community.solar_embassy.service;

import community.solar_embassy.dto.BoardDto;

import java.util.List;

public interface BoardService  {

    List<BoardDto> selectBoardList() throws Exception;
    List<BoardDto> selectBoardListBySize(int size) throws Exception;
    int insertBoard(BoardDto board) throws Exception;  // 게시글 작성 요청 처리
    BoardDto selectBoardDetail(int board_id) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int board_id) throws Exception;

    List<BoardDto> boardListByGalaxy(int galaxyNo);
}