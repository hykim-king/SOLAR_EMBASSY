package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Auto implements Serializable {
    private Integer autoNo;

    private String autoName;

    private String codeName;

    private String comName;

    private Integer com;

    private String autoType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    private Integer seat;

    private Double mpg;

    private String autoEngine;

    private static final long serialVersionUID = 1L;

}