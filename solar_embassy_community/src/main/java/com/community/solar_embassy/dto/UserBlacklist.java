package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserBlacklist {
    private Integer blacklistNo;

    private String userId;

    private String userId2;

    private Integer state;

    private Date updateTime;

}