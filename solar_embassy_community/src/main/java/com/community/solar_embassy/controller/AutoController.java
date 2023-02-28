package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.dto.Company;
import com.community.solar_embassy.service.AutoService;
import com.community.solar_embassy.service.CompanyService;
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
    CompanyService companyService;
    //AutoImgService autoImgService;

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public AutoController(AutoService autoService, CompanyService companyService
    ) {
        this.autoService = autoService;
        this.companyService = companyService;
        //this.autoImgService = autoImgService;
    }

    @GetMapping("/autopedia.do")
    public void autopedia() {
    }

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoName") String autoName,
            //@RequestParam(name = "autoImgNo") int autoImgNo,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoName);
        //AutoImg autoImg = autoImgService.detail(autoImgNo);
        model.addObject("auto", auto);
        //model.addObject("autoImg", autoImg);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }
}
