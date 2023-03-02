package com.community.solar_embassy.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName users
 */
@Data
public class Users implements Serializable {
    private String userId;

    private String nickname;

    private String passwords;
    private String passwords_C;

    private String email;

    private String hp;

    private String tel;

    private String adminId;
    private Admin admin;

    private Date regDate;

    private Date lastLoginTime;

    private Date updateTime;

    private Integer state;

    private Integer cPoint;

    private Integer ePoint;

    private Integer exp;

    private Integer userLevel;

    private Grade grade;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private Integer profileImgNo;

    public Users() {
    }

    public Users(String userId, String nickname, String passwords, String email, String hp, String tel, String adminId, Date birth) {
        this.userId = userId;
        this.nickname = nickname;
        this.passwords = passwords;
        this.email = email;
        this.hp = hp;
        this.tel = tel;
        this.adminId = adminId;
        this.birth = birth;
    }

    private static final long serialVersionUID = 1L;
}