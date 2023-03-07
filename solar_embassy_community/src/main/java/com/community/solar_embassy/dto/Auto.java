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
    private Integer comNo;
    private String comName;
    private String autoType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Integer seat;
    private String mpg;
    private String disp;
    private String price;
    private String autoEngine;
    private String autoImgName;
    private String autoVideo;
    private String Link;
    private static final long serialVersionUID = 1L;

    private List<AutoImg> autoImgList;

}
