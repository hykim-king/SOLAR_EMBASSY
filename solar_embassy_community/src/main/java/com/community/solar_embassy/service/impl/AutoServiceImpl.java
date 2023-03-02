package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.mapper.AutoMapper;
import com.community.solar_embassy.service.AutoService;
import org.springframework.stereotype.Service;


@Service
public class AutoServiceImpl
        implements AutoService {

    private AutoMapper autoMapper;

    public AutoServiceImpl(AutoMapper autoMapper) {
        this.autoMapper = autoMapper;
    }

    @Override
    public Auto detail(int autoNo) {
        return autoMapper.selectByAutoNo(autoNo);
    }
}




