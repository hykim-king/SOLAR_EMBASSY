package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ProfileImg implements Serializable {
    private Integer profileImgNo;

    private String userId;

    private String imgPath;

    private String originImgName;

    private String saveImgName;

    private Date postTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}