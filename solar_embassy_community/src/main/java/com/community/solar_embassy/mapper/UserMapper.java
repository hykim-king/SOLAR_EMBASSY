package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;
import com.community.solar_embassy.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends CRUD<User,String>{
    List<User> findAll();
    User findByUserIdAndPw(String userId, String pw);
    List<User> findPaging(PagingDto paging);
    int deleteById(String id);
    User findById(String id);
    int insert(User dto);
    int update(User dto);



}




