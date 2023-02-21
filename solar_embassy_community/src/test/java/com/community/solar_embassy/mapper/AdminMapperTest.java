package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.Admin;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminMapperTest {
    @Autowired
    public AdminMapper adminMapper;

    Admin admin;
    @BeforeEach
    public void setUp(){
        admin = new Admin("test1",1,"1");
    }

    @Order(0)
    @Test
    void deleteOne() {
        System.out.println("===========테스트 시작===============");
        int delete = adminMapper.deleteOne("test1");
        if(delete==1){
            System.out.println("테스트 전에 입력된 데이터를 지웁니다.");
        }else {
            System.out.println("삭제를 실패하셨습니다.");
        }
    }

    @Test
    public void doUpdate(){
        //삭제
        adminMapper.deleteOne(admin.getAdminId());
        //입력
        adminMapper.insertOne(admin);
        //단건조회
        Admin voDto = adminMapper.findOneByAdminId(admin.getAdminId());
        //voDTO조회한 데이터 수정
        voDto.setAdminLevel(3);
        voDto.setDepartment("관리");
        //업데이트
        adminMapper.modifyOne(voDto);
        //upDTO데이터 데이터 조회
        Admin upDTO=adminMapper.findOneByAdminId(voDto.getAdminId());
        //voDTO, upDTO비교
        assertEquals(voDto.getAdminLevel(),upDTO.getAdminLevel());
        assertEquals(voDto.getDepartment(),upDTO.getDepartment());
    }

    @Order(4)
    @Test
    public void addAndGet(){
        //삭제,단건입력,단건조회, 비교
        //1. 기존데이터 삭제
        adminMapper.deleteOne(admin.getAdminId());

        //2. 단건 입력
        int isertFlag = adminMapper.insertOne(admin);
        assertEquals(1,isertFlag);

        //3. 단건조회
        Admin vsAdmin = adminMapper.findOneByAdminId(admin.getAdminId());

        assertEquals(vsAdmin.getAdminId(), admin.getAdminId());
        assertEquals(vsAdmin.getAdminLevel(), admin.getAdminLevel());
    }

    @Order(1)
    @Test
    void insertOne() {
        Admin admin = new Admin();
        admin.setAdminId("test1");
        admin.setAdminLevel(1);
        int insert = adminMapper.insertOne(admin);
        assertEquals(1,insert);


    }

    @Order(2)
    @Test
    void findOneByAdminId() {
        Admin admin = adminMapper.findOneByAdminId("test1");
        if (admin != null) {
            System.out.println(admin);
            System.out.println("단건조회 완료");
        }else{
            System.out.println("단건조회에 실패하셨습니다.");
        }
    }

    @Order(3)
    @Test
    void modifyOne() {
        Admin admin = new Admin();
        admin.setAdminId("test1");
        admin.setAdminLevel(10);
        admin.setDepartment("최고관리");
        int update = adminMapper.modifyOne(admin);
        if (update == 1) {
            System.out.println(adminMapper.findOneByAdminId("test1"));
            System.out.println("수정이 완료되었습니다.");
        } else {
            System.out.println("수정을 실패하였습니다.");
        }
        System.out.println("============테스트 완료===============");
    }



}