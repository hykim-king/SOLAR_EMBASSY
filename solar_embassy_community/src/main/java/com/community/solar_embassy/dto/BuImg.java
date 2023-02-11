package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class BuImg implements Serializable {
    private Integer buImgNo;

    private String imgPath;

    private String sourceImgName;

    private String saveImgName;

    private Date postTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}