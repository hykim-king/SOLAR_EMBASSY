package com.community.solar_embassy;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@SpringBootApplication
public class SolarEmbassyApplication {
    public static void main(String[] args) {

        SpringApplication.run(SolarEmbassyApplication.class, args);
    }
}