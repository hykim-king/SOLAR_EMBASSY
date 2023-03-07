package com.community.solar_embassy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/letter")
public class LetterController {
    @GetMapping("/main.do")
    public String main(){
        return "msg_main";
    }
}
