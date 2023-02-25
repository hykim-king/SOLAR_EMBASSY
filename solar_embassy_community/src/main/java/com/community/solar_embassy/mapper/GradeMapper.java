package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Grade;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    Grade findByLevel(int userLevel);

    List<Grade> findAll();

    List<Grade> findByPaging(PagingDto paging);

    int insert(Grade grade);

    int update(Grade grade);

    int delete(int userLevel);

}




