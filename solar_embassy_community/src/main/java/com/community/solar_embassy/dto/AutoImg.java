package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutoImg implements Serializable {
    private Integer autoImgNo;

    private Integer autoNo;

    private String autoImgPath;

    private String sourceImgName;

    private static final long serialVersionUID = 1L;
}