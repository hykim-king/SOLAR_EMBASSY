package com.community.solar_embassy.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class GradeDto implements Serializable {
    private Integer userLevel;

    private String grade;

    private Integer totalExp;

    private static final long serialVersionUID = 1L;
}