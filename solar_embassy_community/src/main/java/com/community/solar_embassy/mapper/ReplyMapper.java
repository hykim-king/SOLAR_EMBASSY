package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Reply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
    int deleteById(int replyNo);
    int insert(Reply dto);


}




