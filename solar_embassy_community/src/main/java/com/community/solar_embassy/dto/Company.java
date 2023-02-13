package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Company implements Serializable {
    private Integer comNo;

    private String comName;

    private String address;

    private String pacom;

    private Date foundDate;

    private String founders;

    private String ceo;

    private String industries;

    private String slogan;

    private String content;

    private List<Auto> autoList;

    private static final long serialVersionUID = 1L;
}