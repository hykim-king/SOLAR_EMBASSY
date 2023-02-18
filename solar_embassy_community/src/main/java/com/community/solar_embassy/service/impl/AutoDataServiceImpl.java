package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.AutoData;
import com.community.solar_embassy.mapper.AutoDataMapper;
import com.community.solar_embassy.service.AutoDataService;
import org.springframework.stereotype.Service;

@Service
public class AutoDataServiceImpl implements AutoDataService {
    private AutoDataMapper autoDataMapper;

    public AutoDataServiceImpl(AutoDataMapper autoDataMapper) {
        this.autoDataMapper = autoDataMapper;
    }

    @Override
    public AutoData detail(int dataNo) throws Exception {
        return autoDataMapper.selectAutoDataDetail(dataNo).get(0);
    }
}
