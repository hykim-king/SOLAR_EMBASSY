package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.AutoImg;
import com.community.solar_embassy.mapper.AutoImgMapper;
import com.community.solar_embassy.service.AutoImgService;
import org.springframework.stereotype.Service;

@Service
public class AutoImgServiceImpl implements AutoImgService {
    private AutoImgMapper autoImgMapper;

    public AutoImgServiceImpl(AutoImgMapper autoImgMapper) {
        this.autoImgMapper=autoImgMapper;
    }
    @Override
    public AutoImg detail(int autoImgNo){
        return AutoImgMapper.selectAutoImgDetail(autoImgNo);
    }
}




