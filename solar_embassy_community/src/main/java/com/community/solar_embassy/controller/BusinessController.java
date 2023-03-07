package com.community.solar_embassy.controller;

import com.community.solar_embassy.dto.BusinessDto;
import com.community.solar_embassy.service.BusinessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
@Slf4j
@RestController
@RequiredArgsConstructor
public class BusinessController {
    public final Logger logger = LoggerFactory.getLogger(BusinessController.class);
    private final BusinessService service;

    @PostMapping("/getId")
    public String getId(BusinessDto dto){
        logger.info("BusinessController getId()");
        boolean b = service.addBusiness(dto);
        if(b){
            return "no";
        }
        return "ok";
    }

    @PostMapping("/login")
    public BusinessDto login(BusinessDto dto){
        logger.info("BusinessController login()");
        return service.login(dto);
    }

}
