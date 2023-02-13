package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;
import com.community.solar_embassy.dto.UsersDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UsersMapper extends CRUD<UsersDto,String>{
    UsersDto findByUserIdAndPw(String userId, String passwords);
    List<UsersDto> findAll();
    List<UsersDto> findPaging(PagingDto paging);
    int deleteById(String id);
    UsersDto findById(String id);
    int insert(UsersDto users);
    int update(UsersDto dto);

}




