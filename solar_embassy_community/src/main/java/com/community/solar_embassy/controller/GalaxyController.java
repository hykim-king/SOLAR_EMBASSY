package com.community.solar_embassy.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
@Controller
@RequestMapping("/galaxy")
public class GalaxyController {
    @GetMapping("/autopedia.do")
    public void autopedia(){}
}
