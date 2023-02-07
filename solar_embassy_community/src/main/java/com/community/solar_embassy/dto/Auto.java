package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Auto implements Serializable {
    private Integer autoNo;

    private String autoName;

    private String codeName;

    private Integer com;

    private String autoType;

    private Date releaseDate;

    private Integer seat;

    private Double mpg;

    private String autoEngine;

    private static final long serialVersionUID = 1L;
}