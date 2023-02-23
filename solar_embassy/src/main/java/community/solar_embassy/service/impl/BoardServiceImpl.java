package community.solar_embassy.service.impl;

import community.solar_embassy.dto.BoardDto;
import community.solar_embassy.mapper.BoardMapper;
import community.solar_embassy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public List<BoardDto> selectBoardListBySize(int size) throws Exception {
        return boardMapper.selectBoardListBySize(size);
    }

    // 게시글 작성 요청 처리
    @Override
    public int insertBoard(BoardDto board) throws Exception {
        int insert = boardMapper.insertBoard(board);
        return insert;
    }

    @Override
    public BoardDto selectBoardDetail(int board_no) throws Exception {
        // boardMapper.updateViews(board_no);             // 조회수 증가시키기
        return boardMapper.selectBoardDetail(board_no).get(0);
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);

    }

    @Override
    public void deleteBoard(int board_no) throws Exception {
        boardMapper.deleteBoard(board_no);

    }

    @Override
    public List<BoardDto> boardListByGalaxy(int galaxyNo) {
        return boardMapper.selectBoardListByGalaxy();
    }

}

