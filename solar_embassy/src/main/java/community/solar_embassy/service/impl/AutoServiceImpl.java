package community.solar_embassy.service.impl;

import community.solar_embassy.dto.Auto;
import community.solar_embassy.mapper.AutoMapper;
import community.solar_embassy.service.AutoService;
import org.springframework.stereotype.Service;


@Service
public class AutoServiceImpl implements AutoService {

    private AutoMapper autoMapper;

    public AutoServiceImpl(AutoMapper autoMapper) {
        this.autoMapper = autoMapper;
    }


    @Override
    public Auto detail(String autoName) {
        return autoMapper.selectByAutoName(autoName);
    }
}
