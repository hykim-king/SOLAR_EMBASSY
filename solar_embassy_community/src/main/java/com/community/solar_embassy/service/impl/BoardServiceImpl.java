package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.mapper.BoardMapper;
import com.community.solar_embassy.mapper.GalaxyMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardMapper boardMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    GalaxyMapper galaxyMapper;

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
    public BoardDto selectBoardDetail(int boardNo) throws Exception {
         boardMapper.updateViews(boardNo);             // 조회수 증가시키기
        return boardMapper.selectBoardDetail(boardNo);
    }

    @Override
    public int updateBoard(BoardDto board) throws Exception {
       return boardMapper.updateBoard(board);

    }

    @Override
    public int deleteBoard(int boardNo) throws Exception {
           return boardMapper.deleteBoard(boardNo);

    }


    @Override
    public List<BoardDto> boardListByGalaxy(int galaxyNo) {
        return boardMapper.selectBoardListByGalaxy(galaxyNo);
    }

    @Override
    public List<BoardDto> boardListByGalaxySize(int galaxyNo, int size) {
        return boardMapper.selectBoardListByGalaxySize(galaxyNo,size);
    }

    @Override
    public int lastNo() {
        return boardMapper.selectEnd();
    }

    @Override
    public List<BoardDto> BoardListByUserId(String userId) {
        List<BoardDto> boardList = boardMapper.selectListByUserId(userId);
        for (BoardDto board:boardList){
            board.setUser(usersMapper.findById(userId));
            board.setGalaxy(galaxyMapper.findGalaxy(board.getGalaxyNo()));
        }
        return boardList;
    }

    @Override
    public List<BoardDto> hotList(int endNo) {
        return boardMapper.selectHot(endNo);
    }

}




