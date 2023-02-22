package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Admin;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    int insertOne(Admin admin); // 관리자 한명을 등록하는 메서드

    int modifyOne(Admin admin);

    int deleteOne(String adminId);

    List<Admin> findAll();

    List<Admin> findAllByPaging(PagingDto paging);

    Admin findOneByAdminId(String adminId);
}




