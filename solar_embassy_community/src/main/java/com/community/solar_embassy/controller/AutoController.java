package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.*;
import com.community.solar_embassy.service.AutoService;
import com.community.solar_embassy.service.CompanyService;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public AutoController(AutoService autoService, CompanyService companyService
    ) {
        this.autoService = autoService;
        this.companyService = companyService;
    }

    @GetMapping("/autopedia.do")
    public void autopedia() {}

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoNo") int autoNo,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoNo);
        model.addObject("auto", auto);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }

    @GetMapping("/comDetail.do")
    public ModelAndView comDetail(
            @RequestParam(name = "comNo") int comNo,
            ModelAndView model) throws Exception {
        Company company = companyService.detail(comNo);
        model.addObject("company", company);
        model.setViewName("/galaxy/comDetail");
        return model;
    }

    @GetMapping("autoSearch.do")
    public void search(HttpSession session) {
    }
}