package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.service.AutoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper
@Controller
@RequestMapping("/galaxy")
public class AutoController {

    @Autowired
    AutoService autoService;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @GetMapping("/autopedia.do")
    public String autopedia(Model model) {
        return "/galaxy/autopedia";
    }

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoName") String autoName,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoName);
        model.addObject("auto", auto);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }
}
