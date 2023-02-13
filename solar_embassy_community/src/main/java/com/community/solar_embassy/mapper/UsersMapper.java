package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;
import com.community.solar_embassy.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UsersMapper extends CRUD<Users,String>{
    Users findByUserIdAndPw(String userId, String passwords);
    List<Users> findAll();
    List<Users> findPaging(PagingDto paging);
    int deleteById(String id);
    Users findById(String id);
    int insert(Users users);
    int update(Users dto);
}




