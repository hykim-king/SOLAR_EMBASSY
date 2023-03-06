package com.community.solar_embassy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SolarEmbassyApplication {
    public static void main(String[] args) {

        SpringApplication.run(SolarEmbassyApplication.class, args);
    }
}