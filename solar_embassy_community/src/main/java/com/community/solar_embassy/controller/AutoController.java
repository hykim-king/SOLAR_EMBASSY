package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.dto.AutoImg;
import com.community.solar_embassy.dto.Company;
import com.community.solar_embassy.service.AutoImgService;
import com.community.solar_embassy.service.AutoService;
import com.community.solar_embassy.service.CompanyService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    AutoImgService autoImgService;

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public AutoController(AutoService autoService, AutoImgService autoImgService, CompanyService companyService) {
        this.autoService = autoService;
        this.companyService = companyService;
        this.autoImgService = autoImgService;
    }

    @GetMapping("/autopedia.do")
    public String autopedia() {
        return "/galaxy/autopedia";
    }

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoName") String autoName, @RequestParam(name = "autoImgNo") int autoImgNo,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoName);
        AutoImg autoImg = autoImgService.detail(autoImgNo);
        model.addObject("auto", auto);
        model.addObject("autoImg", autoImg);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }

    @GetMapping("/comDetail.do")
    public ModelAndView comDetail(
            @RequestParam(name = "comName") String comName,
            ModelAndView model) throws Exception {
        Company company = companyService.detail(comName);
        model.addObject("company", company);
        model.setViewName("/galaxy/comDetail");
        return model;
    }
}
