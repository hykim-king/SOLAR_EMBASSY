package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    int deleteById(Reply replyNo);
    int insert(Reply dto);


    List<Reply> findByBoardNo(int boardNo);
}




