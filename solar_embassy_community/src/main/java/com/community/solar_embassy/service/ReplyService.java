package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.Reply;

import java.util.List;

public interface ReplyService  {
    int register(Reply reply);
    int delete(Reply replyNo);
    int modifyOne(Reply reply);

    List<Reply> findByBoardNo(int boardNo);
    List<Reply> findByFkReplyNo(int replyNo);

    List<Reply> findFirstByBoardNo(int boardNo);

    Reply findOne(int replyNo);

    List<Reply> findByUserId(String userId);
}
