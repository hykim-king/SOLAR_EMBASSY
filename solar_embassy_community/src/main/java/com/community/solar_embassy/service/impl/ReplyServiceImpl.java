package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.mapper.ReplyMapper;
import com.community.solar_embassy.service.ReplyService;
import org.springframework.stereotype.Service;


@Service
public class ReplyServiceImpl implements ReplyService {
    private ReplyMapper replyMapper;
    public ReplyServiceImpl(ReplyMapper replyMapper) {
        this.replyMapper = replyMapper;
    }

    @Override
    public int register(Reply reply) {
        return replyMapper.insert(reply);
    }
}




