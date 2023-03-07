package com.community.solar_embassy.service.impl;

import com.community.solar_embassy.dto.BusinessDto;
import com.community.solar_embassy.mapper.BusinessMapper;
import com.community.solar_embassy.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional  //모든 작업들이 성공적으로 완료되어야 작업 묶음의 결과를 적용하고, 어떤 작업에서 오류가 발생했을 때는 이전에 있던 모든 작업들이 성공적이었더라도 없었던 일처럼 완전히 되돌리는 것이 트랜잭션의 개념이다.
@RequiredArgsConstructor  //  초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해준다.
public class BusinessServiceImpl implements BusinessService{

    private final BusinessMapper BusinessMapper;

    @Override
    public boolean getId(BusinessDto dto) {
        int n = BusinessMapper.getId(dto);
        return n > 0;
    }
    @Override
    public boolean addBusiness(BusinessDto dto)
    {
        int n = BusinessMapper.addBusiness(dto);
        return n > 0;
    }
    @Override
    public BusinessDto login(BusinessDto dto) {
        return BusinessMapper.login(dto);
    }
}




