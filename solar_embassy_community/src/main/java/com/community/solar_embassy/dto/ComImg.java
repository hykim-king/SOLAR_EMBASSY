package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ComImg implements Serializable {
    private Integer comImgNo;

    private Integer comNo;

    private String comImgPath;

    private String sourceImgName;

    private static final long serialVersionUID = 1L;
}
