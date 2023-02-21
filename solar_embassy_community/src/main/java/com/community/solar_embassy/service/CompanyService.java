package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.Company;

public interface CompanyService {
    Company detail(String comName) throws Exception;
}
