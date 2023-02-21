package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Reply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ReplyMapperTest {
    @Autowired
    private ReplyMapper replyMapper;
    private Logger log= LoggerFactory.getLogger(this.getClass());

    Reply reply;
    @BeforeEach
    public void setUp(){
        reply = new Reply(1,1,"user1","안녕하세요");
    }


    @Test
    void insertReply() {
        Reply reply=new Reply();
        reply.setReplyNo(1);
        reply.setBoardNo(1);
        reply.setUserId("user1");
        reply.setContents("안녕하세요!");
        int insert = replyMapper.insertReply(reply);
        assertEquals(1,insert);
    }

    @Test
    void updateReply(){
        Reply reply=new Reply();
        reply.setContents("수정 안녕하세요!!!!");
        reply.setReplyNo(1);
        replyMapper.updateReply(reply);

    }


    @Test
    void deleteById() throws Exception{
        Reply reply = new Reply();
        reply.setReplyNo(1);
        replyMapper.deleteById(reply);

    }




}