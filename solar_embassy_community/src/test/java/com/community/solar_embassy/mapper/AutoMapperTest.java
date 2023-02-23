package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Auto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;

@SpringBootTest
class AutoMapperTest {
    @Autowired
    private AutoMapper autoMapper;
    @Test
    void selectAutoDetail() throws Exception {
        Auto auto = new Auto();
        auto.setAutoNo(1);
        auto.setAutoName("그랜저");
        auto.setCodeName("GN7");
        auto.setDetailName("2023년형 가솔린 2.0");
        auto.setOptionName("익스클루시브 (A/T)");
        auto.setComNo(1);
        auto.setComName("현대자동차");
        auto.setAutoType("준대형 세단");
        auto.setReleaseDate(new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-10"));
        auto.setSeat(5);
        auto.setMpg(18.0);
        auto.setDisp(3470);
        auto.setPrice(5121);
        auto.setAutoEngine("가솔린 엔진");
        autoMapper.selectAutoDetail("The All New 그랜저");
        System.out.println(auto);
    }
}