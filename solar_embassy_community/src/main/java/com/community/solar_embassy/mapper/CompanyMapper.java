package com.community.solar_embassy.mapper;


import com.community.solar_embassy.dto.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {
    List<Company> selectCompanyDetail(String comName) throws Exception;
    int insert(Company company);
}




