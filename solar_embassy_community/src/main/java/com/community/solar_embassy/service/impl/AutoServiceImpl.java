package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Auto;
import com.community.solar_embassy.mapper.AutoImgMapper;
import com.community.solar_embassy.mapper.AutoMapper;
import com.community.solar_embassy.service.AutoService;
import org.springframework.stereotype.Service;


@Service
public class AutoServiceImpl
        implements AutoService {

    private AutoMapper autoMapper;
    private AutoImgMapper autoImgMapper;

    public AutoServiceImpl(AutoMapper autoMapper, AutoImgMapper autoImgMapper) {
        this.autoMapper = autoMapper;
        this.autoImgMapper = autoImgMapper;
    }

    @Override
    public Auto detail(int autoNo) {
        Auto auto = autoMapper.selectByAutoNo(autoNo);
        auto.setAutoImgList(autoImgMapper.selectAutoList(autoNo));
        return auto;
    }
}
