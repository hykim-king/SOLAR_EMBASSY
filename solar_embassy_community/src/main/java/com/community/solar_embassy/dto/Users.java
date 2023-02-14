package com.community.solar_embassy.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
    private String userId;

    private String nickname;

    private String passwords;

    private String email;

    private String hp;

    private String tell;

    private String adminId;

    private Date regDate;

    private Date lastLoginTime;

    private Date updateTime;

    private Integer state;

    private Integer cPoint;

    private Integer ePoint;

    private Integer exp;

    private Integer userLevel;

    private Date birth;

    private Integer profileImgNo;

    private ProfileImg profileImg;

    private Admin admin;

    private Grade grade;

    private List<Letter> letterList;

    private List<UserBlock> userBlockList;

    private List<Booking> bookingList;

}