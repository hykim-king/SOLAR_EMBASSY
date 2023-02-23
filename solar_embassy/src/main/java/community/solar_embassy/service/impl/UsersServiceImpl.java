package community.solar_embassy.service.impl;

import community.solar_embassy.dto.Users;
import community.solar_embassy.mapper.ProfileImgMapper;
import community.solar_embassy.mapper.UsersMapper;
import community.solar_embassy.service.UsersService;
import org.springframework.stereotype.Service;


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
}