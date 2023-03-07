package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName grade
 */
@Data
public class Grade implements Serializable {
    private Integer userLevel;

    private String grade;

    private Integer totalExp;
    private GradeImg gradeImg;

    public Grade() {
    }

    public Grade(Integer userLevel, String grade, Integer totalExp) {
        this.userLevel = userLevel;
        this.grade = grade;
        this.totalExp = totalExp;
    }

    private static final long serialVersionUID = 1L;
}