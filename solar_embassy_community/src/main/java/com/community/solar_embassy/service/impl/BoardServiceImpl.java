package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.*;
import com.community.solar_embassy.mapper.*;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.ReplyService;
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
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    GradeImgMapper gradeImgMapper;

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
        usersMapper.getPoints(50,50,board.getUserId());
        usersMapper.expUp(10,board.getUserId());
        return insert;
    }

    @Override
    public BoardDto selectBoardDetail(int boardNo) throws Exception {
        BoardDto board = boardMapper.selectBoardDetail(boardNo);
        // userId로 user 정보 찾기
        board.setUser(usersMapper.findById(board.getUserId()));
        Users user = board.getUser();
        // user 의 grade 정보 찾기
        user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
        Grade grade = user.getGrade();
        // grade 의 grade img 찾기
        grade.setGradeImg(gradeImgMapper.findByGrade(grade.getGrade()));
        // 정보 업데이트
        user.setGrade(grade);
        board.setUser(user);
        boardMapper.updateViews(boardNo);             // 조회수 증가시키기
        return board;
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
        List<BoardDto> boardList = boardMapper.selectBoardListByGalaxy(galaxyNo);
        for (BoardDto board : boardList) {
            // userId로 user 정보 찾기
            board.setUser(usersMapper.findById(board.getUserId()));
            Users user = board.getUser();
            // user 의 grade 정보 찾기
            user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
            Grade grade = user.getGrade();
            // grade 의 grade img 찾기
            grade.setGradeImg(gradeImgMapper.findByGrade(grade.getGrade()));
            // 정보 업데이트
            user.setGrade(grade);
            board.setUser(user);
        }
        return boardList;
    }

    @Override
    public List<BoardDto> boardListByGalaxySize(int galaxyNo, int size) {
        return boardMapper.selectBoardListByGalaxySize(galaxyNo, size);
    }

    @Override
    public int lastNo() {
        return boardMapper.selectEnd();
    }

    @Override
    public List<BoardDto> BoardListByUserId(String userId) {
        List<BoardDto> boardList = boardMapper.selectListByUserId(userId);
        for (BoardDto board : boardList) {
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



