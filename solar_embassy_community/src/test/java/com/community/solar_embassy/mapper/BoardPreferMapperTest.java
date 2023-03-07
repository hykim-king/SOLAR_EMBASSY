package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardPreferDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardPreferMapperTest {
    @Autowired
    BoardPreferMapper boardPreferMapper;
    @Test
    void countByBoardNoAndPreferIsTrue() {
        System.out.println(boardPreferMapper.countByBoardNoAndPreferIsTrue(12));
    }

    @Test
    void countByBoardNoAndPreferIsFalse() {
        System.out.println(boardPreferMapper.countByBoardNoAndPreferIsFalse(12));
    }

    @Test
    void findByBoardNoAndUserId() {
        BoardPreferDto boardPreferDto;
        boardPreferDto = boardPreferMapper.findByBoardNoAndUserId(12,"user5");
        System.out.println(boardPreferDto);
    }
}