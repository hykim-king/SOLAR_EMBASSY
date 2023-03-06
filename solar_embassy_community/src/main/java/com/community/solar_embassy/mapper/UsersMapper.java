package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;
import com.community.solar_embassy.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    Users findByUserIdAndPw(String userId, String passwords); // 로그인 : 비밀번호 단계

    int updateLogin(String userId);

    List<Users> findAll();

    List<Users> findPaging(PagingDto paging);

    Users findById(String userId); // 회원정보 찾기 + 로그인 : 아이디 단계

    int insert(Users user);

    int update(Users user);

    int delete(String userId);

    int getPoints(int cPoint, int ePoint, String userId);

    int expUp(int exp,String userId);
    int levelUp(Users users);

    Users findByNickname(String nickname);
}




