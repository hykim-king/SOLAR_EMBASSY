package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Users;
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
    public Users login(String userId, String pw) {
        return usersMapper.findByUserIdAndPw(userId, pw);
    }

    @Override
    public int signup_normal(Users users) {
        return usersMapper.insert(users);
    }
}



