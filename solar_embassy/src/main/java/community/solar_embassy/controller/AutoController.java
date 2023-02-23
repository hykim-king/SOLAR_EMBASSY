package community.solar_embassy.controller;

import community.solar_embassy.dto.Auto;
import community.solar_embassy.service.AutoService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Mapper
@Controller
@RequestMapping("/galaxy")
public class AutoController {
    private AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/autopedia.do")
    public void autopedia(){}

    @GetMapping("/autoDetail.do")
    public ModelAndView autoDetail(
            @RequestParam(name = "autoName") String autoName,
            ModelAndView model) throws Exception {
        Auto auto = autoService.detail(autoName);
        model.addObject("auto", auto);
        model.setViewName("/galaxy/autoDetail");
        return model;
    }}