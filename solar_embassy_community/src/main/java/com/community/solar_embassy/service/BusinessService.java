package com.community.solar_embassy.service;


import com.community.solar_embassy.dto.BusinessDto;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessService {
    boolean getId(BusinessDto dto);
    // 회원가입: BusinessDto를 받아 추가되는 경우 숫자 카운트
    boolean addBusiness(BusinessDto dto);
    // 로그인 : BusinessDto 받고 BusinessDto 반환
    BusinessDto login(BusinessDto dto);
}
