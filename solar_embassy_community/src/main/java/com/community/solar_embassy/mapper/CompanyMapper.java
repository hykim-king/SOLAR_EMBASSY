package com.community.solar_embassy.mapper;


import com.community.solar_embassy.dto.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    Company findCompany(int com);

}




