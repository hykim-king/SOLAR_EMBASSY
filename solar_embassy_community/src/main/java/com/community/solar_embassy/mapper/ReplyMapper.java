package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int deleteById(Reply replyNo);
    int insertReply(Reply reply);
    int updateReply(Reply reply);
    List<Reply> findByBoardNo(int boardNo);
    List<Reply> findAllByFkReplyNo(int replyNo);
    List<Reply> findAll();
    List<Reply> findByBoardNoPaging(int boardNo);
    Reply findById(int replyNo );
    List<Reply> findByUserIdPaging(String userId); //유저 상세에서 작성한 댓글 리스트
    int countByUserId(String userId);

    int countByBoardNo(int boardNo);

    int makeBlankReply(Reply replyNo);
}




