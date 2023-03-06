package com.community.solar_embassy.service;

import com.community.solar_embassy.dto.Users;

import java.util.List;

public interface UsersService {

    Users login(String userId, String pw);

    int signup_normal(Users users);

    int modify(Users user);

    int findNick(String nickname);

    Users findById(String userId);

    int expUp(String userId);

    int withdrawal(Users loginUser);
}