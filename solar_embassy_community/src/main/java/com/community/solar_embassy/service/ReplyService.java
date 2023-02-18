package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.Reply;

import java.util.List;

public interface ReplyService  {
    int register(Reply reply);
    int delete(Reply reply);

    List<Reply> findByBoardNo(int boardNo);
}
