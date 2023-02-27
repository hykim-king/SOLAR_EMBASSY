package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName grade_img
 */
@Data
public class GradeImg implements Serializable {
    private String grade;

    private String imgPath;

    private String originImgName;

    private static final long serialVersionUID = 1L;

    public GradeImg(String grade, String imgPath, String originImgName) {
        this.grade = grade;
        this.imgPath = imgPath;
        this.originImgName = originImgName;
    }

    public GradeImg() {
    }
}