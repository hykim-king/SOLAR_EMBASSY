package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName auto
 */
@Data
public class Auto implements Serializable {
    private Integer autoNo;

    private String autoName;

    private String codeName;

    private String detailName;

    private String optionName;

    private Integer comNo;

    private String comName;

    private String autoType;

    private Date releaseDate;

    private Integer seat;

    private Double mpg;

    private Double disp;

    private Integer price;

    private String autoEngine;

    private static final long serialVersionUID = 1L;
}