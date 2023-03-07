package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.Galaxy;

import java.util.List;

public interface GalaxyService {

    List<Galaxy> findAll();

    Galaxy findByNo(int galaxyNo);
}
