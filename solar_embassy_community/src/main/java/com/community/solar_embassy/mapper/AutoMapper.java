package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;
import com.community.solar_embassy.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
<<<<<<< HEAD:solar_embassy_community/src/main/java/com/community/solar_embassy/mapper/AutoMapper.java
public interface AutoMapper {
=======
public interface UserMapper extends CRUD<User,String>{
    List<User> findAll();
    User findByUserIdAndPw(String userId, String pw);
    List<User> findPaging(PagingDto paging);
    int deleteById(String id);
    User findById(String id);
    int insert(User dto);
    int update(User dto);


>>>>>>> dfb3e29c6e88d465bf4e178909db2e2065f01863:solar_embassy_community/src/main/java/com/community/solar_embassy/mapper/UserMapper.java

}




