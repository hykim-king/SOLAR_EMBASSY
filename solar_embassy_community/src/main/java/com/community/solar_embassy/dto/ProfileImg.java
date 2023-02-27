package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName profile_img
 */
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

    public ProfileImg(String userId, String imgPath, String originImgName, String saveImgName) {
        this.userId = userId;
        this.imgPath = imgPath;
        this.originImgName = originImgName;
        this.saveImgName = saveImgName;
    }

    public ProfileImg() {
    }
}