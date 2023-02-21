package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.mapper.ReplyMapper;
import com.community.solar_embassy.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {
    private ReplyMapper replyMapper;
    public ReplyServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public int register(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public int delete(Reply reply) {
        return replyMapper.deleteById(reply);
    }


    @Override
    public List<Reply> findByBoardNo(int boardNo) {
        return replyMapper.findByBoardNo(boardNo);
    }
}




