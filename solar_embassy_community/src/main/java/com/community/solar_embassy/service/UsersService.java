package com.community.solar_embassy.service;

import com.community.solar_embassy.dto.UsersDto;

public interface UsersService {

    UsersDto login(String userId, String pw);

    int signup_normal(UsersDto users);
}