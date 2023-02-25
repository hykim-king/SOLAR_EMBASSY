package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int deleteById(Reply replyNo);
    int insertReply(Reply dto);
    int updateReply(Reply reply);
    List<Reply> findByBoardNo(int boardNo);
    List<Reply> findAllByFkReplyNo(int replyNo);
    List<Reply> findAll();

}




