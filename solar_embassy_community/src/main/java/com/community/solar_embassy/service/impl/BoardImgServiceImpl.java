package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BoardImg;
import com.community.solar_embassy.mapper.BoardImgMapper;
import com.community.solar_embassy.service.BoardImgService;
import org.springframework.stereotype.Service;


@Service
public class BoardImgServiceImpl
        implements BoardImgService {
    BoardImgMapper boardImgMapper;

    public BoardImgServiceImpl(BoardImgMapper boardImgMapper) {
        this.boardImgMapper = boardImgMapper;
    }

    @Override
    public BoardImg selectOne(Integer boardNo) {
        return boardImgMapper.findByBoardNo(boardNo);
    }
}



