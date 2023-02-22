package com.community.solar_embassy.mapper;

<<<<<<< HEAD

import com.community.solar_embassy.dto.BusinessDto;
=======
>>>>>>> 69a5ab68b59c6e2c9478a29653c95fb104023b62
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BusinessMapper {
    // 아이디 중복 확인 : db체크 후 아이디가 존재하면 숫자가 카운트되면서 중복이 없을 경우 0qksghks
    int getId(BusinessDto dto);
    // 회원가입: BusinessDto를 받아 추가되는 경우 숫자 카운트
    int addBusiness(BusinessDto dto);
    // 로그인 : BusinessDto 받고 BusinessDto 반환
    BusinessDto login(BusinessDto dto);

}




