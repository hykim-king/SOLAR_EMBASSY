package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.dto.AutoData;
import com.community.solar_embassy.service.AutoService;
import com.community.solar_embassy.service.AutoDataService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    AutoDataService autoDataService;

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public AutoController(AutoService autoService, AutoDataService autoDataService) {
        this.autoService = autoService;
        this.autoDataService = autoDataService;
    }

    @GetMapping("/autopedia.do")
    public String autopedia() {
        return "/galaxy/autopedia";
    }

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoName") String autoName, @RequestParam int dataNo,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoName);
        AutoData autoData = autoDataService.detail(dataNo);
        model.addObject("auto", auto);
        model.addObject("autoData", autoData);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }
}
