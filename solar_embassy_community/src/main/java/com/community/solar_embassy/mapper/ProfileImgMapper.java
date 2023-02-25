package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.ProfileImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileImgMapper {
    int insert(ProfileImg profileImg);
    int update(ProfileImg profileImg);
    int delete(int profileImgNo);
    int resetNo(int profileImagNo);
    int lastIndex();
    ProfileImg findByNo(int profileImgNo);
    List<ProfileImg> findAll();
    List<ProfileImg> findAble(String userId);

}




