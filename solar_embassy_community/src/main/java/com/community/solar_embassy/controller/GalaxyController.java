package com.community.solar_embassy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/galaxy")
public class GalaxyController {
    @GetMapping("autopedia.do")
    public void autopedia(){}
}
