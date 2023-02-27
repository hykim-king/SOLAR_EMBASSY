package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")

public class IndexController {
    private BoardService boardService;

    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String index(Model model) throws Exception {
        List<BoardDto> list = boardService.selectBoardListBySize(5);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list", list);
        return "/index";
    }
    @GetMapping("introduce")
    public String introduce(){
        return "1. introduce";
    }
    @GetMapping("user_rules")
    public String user_rules(){
        return "2. user_rules";
    }
    @GetMapping("personal")
    public String personal(){
        return "3. personal";
    }

}
