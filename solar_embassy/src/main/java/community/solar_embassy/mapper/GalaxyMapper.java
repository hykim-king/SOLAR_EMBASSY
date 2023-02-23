package community.solar_embassy.mapper;

import community.solar_embassy.dto.Galaxy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalaxyMapper {
    Galaxy findGalaxy(int galaxyNo);

    List<Galaxy> findAll();
}

