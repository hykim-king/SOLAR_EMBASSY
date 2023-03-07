package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Users;
import com.community.solar_embassy.mapper.GradeMapper;
import com.community.solar_embassy.mapper.ProfileImgMapper;
import com.community.solar_embassy.mapper.UsersMapper;
import com.community.solar_embassy.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    private UsersMapper usersMapper;
    private ProfileImgMapper profileImgMapper;
    private GradeMapper gradeMapper;

    public UsersServiceImpl(UsersMapper usersMapper, ProfileImgMapper profileImgMapper, GradeMapper gradeMapper) {
        this.usersMapper = usersMapper;
        this.profileImgMapper = profileImgMapper;
        this.gradeMapper = gradeMapper;
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
        Users user = usersMapper.findById(userId);
        user.setGrade(gradeMapper.findByLevel(user.getUserLevel()));
        levelUpdate(user);

        return user;
    }

    private void levelUpdate(Users user) {
        if(user.getGrade().getTotalExp()<=user.getExp()){
            usersMapper.levelUp(user);
            user=usersMapper.findById(user.getUserId());
            levelUpdate(user);
        }
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



