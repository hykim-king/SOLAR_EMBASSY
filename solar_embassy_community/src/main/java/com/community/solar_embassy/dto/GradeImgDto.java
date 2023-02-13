package com.community.solar_embassy.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class GradeImgDto implements Serializable {
    private String grade;

    private String imgPath;

    private String originImgName;

    private static final long serialVersionUID = 1L;
}