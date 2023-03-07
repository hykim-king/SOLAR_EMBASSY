package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Room implements Serializable {
    private String buTell;

    private Date postTime;

    private String licenseName;

    private String licenseNum;

    private Integer roomNo;

    private String title;

    private String address;

    private String  roCount;

    private String price;

    private Date checkin;

    private Date checkout;

    private String info;

    private String updaterId;

    private Date updateTime;

    private String imgPath;

    private String sourceImgName;

    private String saveImgName;

    private Integer buNo;

    private Integer buCode;

    private static final long serialVersionUID = 1L;
}