package com.community.solar_embassy.controller;


import com.community.solar_embassy.dto.BoardDto;
import com.community.solar_embassy.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boardTest")
public class boardTestController {
    @Autowired
    BoardService boardService;

    @GetMapping("/boardTest.do")
    public void boardWrite(){
    }




}
