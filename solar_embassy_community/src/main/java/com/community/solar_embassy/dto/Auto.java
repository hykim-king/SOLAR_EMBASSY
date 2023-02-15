package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Auto implements Serializable {
    private Integer autoNo;

    private String autoName;

    private String codeName;

    private Integer com;
    private Company company;

    private String autoType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private Integer seat;

    private Double mpg;

    private String autoEngine;

    private List<AutoImg> autoImgList;

    private static final long serialVersionUID = 1L;
}