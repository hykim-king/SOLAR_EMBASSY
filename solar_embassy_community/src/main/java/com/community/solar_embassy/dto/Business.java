package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Business implements Serializable {
    private String crNum;

    private String buTell;

    private String buId;

    private String buPasswords;

    private String buName;

    private String email;

    private String buTitle;

    private String buAddress;

    private Integer buCode;

    private Integer crImgNo;

    private String imgPath;

    private String sourceImgName;

    private String saveImgName;

    private Date regDate;

    private Date updateTime;


    private static final long serialVersionUID = 1L;
}