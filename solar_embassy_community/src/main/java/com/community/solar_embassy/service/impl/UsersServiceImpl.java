package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.UsersDto;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.UsersService;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {

    private UsersMapper usersMapper;

    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public UsersDto login(String userId, String pw) {
        return usersMapper.findByUserIdAndPw(userId, pw);
    }

    @Override
    public int signup_normal(UsersDto users) {
        return usersMapper.insert(users);
    }
}



