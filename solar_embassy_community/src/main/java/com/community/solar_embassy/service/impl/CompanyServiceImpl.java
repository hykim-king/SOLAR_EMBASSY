package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.Company;
import com.community.solar_embassy.mapper.CompanyMapper;
import com.community.solar_embassy.service.CompanyService;
import org.springframework.stereotype.Service;


@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public Company detail(int comNo) throws Exception {
        return companyMapper.selectCompanyDetail(comNo).get(0);
    }
}




