package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.service.BoardService;
import com.community.solar_embassy.service.GalaxyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {
    private BoardService boardService;
    private GalaxyService galaxyService;

    public IndexController(BoardService boardService, GalaxyService galaxyService) {
        this.boardService = boardService;
        this.galaxyService = galaxyService;
    }

    @GetMapping("/")
    public String index(Model model) throws Exception {
        List<BoardDto> list = boardService.selectBoardListBySize(7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        int endNo = boardService.lastNo() ;
        List<BoardDto> hotlist = boardService.hotList(endNo);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        for(BoardDto boardDto:hotlist){
            boardDto.setGalaxy(galaxyService.findByNo(boardDto.getGalaxyNo()));
        }
        List<BoardDto> list1 = boardService.boardListByGalaxySize(1,7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list2 = boardService.boardListByGalaxySize(2,7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list3 = boardService.boardListByGalaxySize(3,7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list4 = boardService.boardListByGalaxySize(4,7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        List<BoardDto> list5 = boardService.boardListByGalaxySize(5,7);//service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
        model.addAttribute("list", list);
        model.addAttribute("hotlist", hotlist);
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
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
    @GetMapping("customer_center")
    public String customer_center() {
        return "customer_center";
    }

}
