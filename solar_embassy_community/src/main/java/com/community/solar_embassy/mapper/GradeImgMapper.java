package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.GradeImg;
import com.community.solar_embassy.dto.PagingDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeImgMapper {
    int changeGrade(String grade, String newGrade);

    int update(GradeImg gradeImg);

    int insert(GradeImg gradeImg);

    GradeImg findByGrade(String grade);

    int delete(String grade);

    List<GradeImg> findAll();
    List<GradeImg> findByPaging(PagingDto paging);

}




