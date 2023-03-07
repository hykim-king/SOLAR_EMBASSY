package com.community.solar_embassy.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    void selectBoardListByGalaxy() {
        boardMapper.selectBoardListByGalaxy(1);
    }
}