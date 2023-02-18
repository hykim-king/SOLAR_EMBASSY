package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AutoData implements Serializable {
    private Integer dataNo;

    private String pData;

    private String autoName;

    private String subData;

    private Integer disp;

    private Integer price;

    private static final long serialVersionUID = 1L;
}
