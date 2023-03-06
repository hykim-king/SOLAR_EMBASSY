package com.community.solar_embassy.google;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;


// 소셜 로그인 사용자 정보를 담을 별도의 User 클래스
@Entity
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;
    private String picture;
    private String role = "ROLE_USER";

    public User(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public User() {

    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    // .. getter, setter 생략
}