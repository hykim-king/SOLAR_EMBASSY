package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.mapper.ProfileImgMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    private UsersMapper usersMapper;
    private ProfileImgMapper profileImgMapper;

    public UsersServiceImpl(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Users login(String userId, String pw) {
        Users user = usersMapper.findByUserIdAndPw(userId, pw);
        return user;
    }

    @Override
    public int signup_normal(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public int modify(Users user) {
        return usersMapper.update(user);
    }

    @Override
    public int findNick(String nickname) {
        Users findResult = usersMapper.findByNickname(nickname);
        int check = 0;
        if (findResult != null) {
            check=1;
        }
        return check;
    }

    @Override
    public Users findById(String userId) {
        return usersMapper.findById(userId);
    }

    @Override
    public int withdrawal(Users loginUser) {
        return usersMapper.delete(loginUser.getUserId());
    }

    @Override
    public int expUp(String userId) {
        return usersMapper.expUp(5,userId);
    }
}



