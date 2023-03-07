package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Reply;
import com.community.solar_embassy.mapper.ReplyMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl
        implements ReplyService {
    private ReplyMapper replyMapper;
    private UsersMapper usersMapper;

    public ReplyServiceImpl(ReplyMapper replyMapper, UsersMapper usersMapper) {
        this.replyMapper = replyMapper;
        this.usersMapper = usersMapper;
    }

    @Override
    public int register(Reply reply) {
        int register = replyMapper.insertReply(reply);
        if (register==1){

        }
        return register;
    }

    @Override
    public int modifyOne(Reply reply) {
        return replyMapper.updateReply(reply);
    }

    @Override
    public int delete(Reply replyNo) {
        int delete = 0;
        if (replyNo.getFkReplyNo() == null) {
            delete = replyMapper.makeBlankReply(replyNo);
        } else {
            delete = replyMapper.deleteById(replyNo);
        }
        return delete;
    }


    @Override
    public List<Reply> findByBoardNo(int boardNo) {
        List<Reply> replyList = replyMapper.findByBoardNo(boardNo);
        for (Reply reply : replyList) {
            if (reply.getUserId() != null) {
                reply.setNickname(usersMapper.findById(reply.getUserId()).getNickname());
            }
        }
        return replyList;

    }

    @Override
    public List<Reply> findByFkReplyNo(int replyNo) {
        List<Reply> replyList = replyMapper.findAllByFkReplyNo(replyNo);
        for (Reply reply : replyList) {
            reply.setNickname(usersMapper.findById(reply.getUserId()).getNickname());
        }
        return replyList;
    }

    @Override
    public List<Reply> findFirstByBoardNo(int boardNo) {
        List<Reply> replyList = replyMapper.findByBoardNoPaging(boardNo);
        for (Reply reply : replyList) {
            reply.setUser(usersMapper.findById(reply.getUserId()));
        }
        return replyList;
    }

    @Override
    public Reply findOne(int replyNo) {
        return replyMapper.findById(replyNo);
    }

}




