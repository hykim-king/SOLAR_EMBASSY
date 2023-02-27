package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Galaxy;
import com.community.solar_embassy.mapper.GalaxyMapper;
import com.community.solar_embassy.service.GalaxyService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GalaxyServiceImpl implements GalaxyService {
    private GalaxyMapper galaxyMapper;

    public GalaxyServiceImpl(GalaxyMapper galaxyMapper) {
        this.galaxyMapper = galaxyMapper;
    }

    @Override
    public List<Galaxy> findAll() {
        return galaxyMapper.findAll();
    }

    @Override
    public Galaxy findByNo(int galaxyNo) {
        return galaxyMapper.findGalaxy(galaxyNo);
    }
}




