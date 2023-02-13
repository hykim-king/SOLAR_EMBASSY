package com.community.solar_embassy.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class Grade implements Serializable {
    private Integer userLevel;

    private String grade;

    private Integer totalExp;

    private GradeImg gradeImg;

    private static final long serialVersionUID = 1L;
}