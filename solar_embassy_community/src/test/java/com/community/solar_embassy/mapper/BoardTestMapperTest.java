package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BoardTestMapperTest {

    @Autowired
    private BoardMapper boardMapper;
//    private Logger log = (Logger) LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Test
    void insertBoard() throws Exception {

        BoardDto board = new BoardDto();

        board.setBoardNo(1);
        board.setGalaxyNo(1);
        board.setUserId("user1");
        board.setBoardTag(1);
        board.setTitle("테스트");
        board.setContents("테스트 콘텐츠");
        board.setPostTime(new Date());
        board.setUpdaterId("user");
        board.setUpdateTime(new Date());
        board.setState(1);
        board.setLikes(1);
        board.setDislikes(1);
        board.setViews(1);
        System.out.println(board);

        boardMapper.insertBoard(board);
//        log.info(board.toString());




    }
}