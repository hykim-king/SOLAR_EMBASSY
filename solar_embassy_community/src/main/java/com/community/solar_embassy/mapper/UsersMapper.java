package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UsersMapper {
    Users findByUserIdAndPw(String userId, String pw);

    int insert(Users users);
}




