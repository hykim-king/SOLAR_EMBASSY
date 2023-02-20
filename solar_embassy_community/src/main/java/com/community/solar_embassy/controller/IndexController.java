package com.community.solar_embassy.controller;
<<<<<<< HEAD
=======

>>>>>>> 3e359ae2778b4cddcd7a068a7e6df5609a978007
import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
<<<<<<< HEAD
@Controller

=======

@Controller
>>>>>>> 3e359ae2778b4cddcd7a068a7e6df5609a978007
public class IndexController {
    private BoardService boardService;

    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<BoardDto> list = boardService.selectBoardList();//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list", list);
        return "/index";
    }
}
