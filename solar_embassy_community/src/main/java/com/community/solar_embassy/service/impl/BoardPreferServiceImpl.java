package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BoardPreferDto;
import com.community.solar_embassy.dto.BoardPreferViewDto;
import com.community.solar_embassy.mapper.BoardMapper;
import com.community.solar_embassy.mapper.BoardPreferMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.BoardPreferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BoardPreferServiceImpl implements BoardPreferService {
    private BoardMapper boardMapper;
    private BoardPreferMapper boardPreferMapper;
    private UsersMapper usersMapper;

    public BoardPreferServiceImpl(BoardMapper BoardMapper, BoardPreferMapper BoardPreferMapper, UsersMapper usersMapper) {
        this.boardMapper = BoardMapper;
        this.boardPreferMapper = BoardPreferMapper;
        this.usersMapper = usersMapper;
    }

    @Transactional
    @Override
    public BoardPreferViewDto detailBoardPreferView(int boardNo, String loginUserId) {
        BoardPreferViewDto detailPreferView;
        detailPreferView = new BoardPreferViewDto();
        int likes = boardPreferMapper.countByBoardNoAndPreferIsTrue(boardNo);
        detailPreferView.setLikes(likes);
        int dislikes = boardPreferMapper.countByBoardNoAndPreferIsFalse(boardNo);
        detailPreferView.setDislikes(dislikes);
        if (loginUserId != null){
            // 여기서 null 값이 붙는 거 같네요
            BoardPreferDto loginUserPrefer = boardPreferMapper.findByBoardNoAndUserId(boardNo,loginUserId);
            //정보가 없으니 여기서 null 값을 받아오고
            detailPreferView.setLoginUserPrefer(loginUserPrefer);
        }
        return detailPreferView;
    }

    @Override
    public int register(BoardPreferDto boardPrefer) {
        int insert = boardPreferMapper.insert(boardPrefer);
        return insert;
    }

    @Override
    public int modify(BoardPreferDto boardPrefer) {
        return boardPreferMapper.update(boardPrefer);
    }

    @Override
    public int remove(int boardPreferNo) {
        return boardPreferMapper.delete(boardPreferNo);
    }

    @Override
    public BoardPreferDto detail(int boardNo, String loginUserId) {
        BoardPreferDto detail = boardPreferMapper.findByBoardNoAndUserId(boardNo,loginUserId);
        return detail;
    }
}
