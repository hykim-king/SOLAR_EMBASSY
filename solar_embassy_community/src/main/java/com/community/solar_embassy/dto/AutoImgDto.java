package com.community.solar_embassy.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class AutoImgDto implements Serializable {
    private Integer autoImgNo;

    private Integer autoNo;

    private String autoImgPath;

    private String sourceImgName;

    private static final long serialVersionUID = 1L;
}