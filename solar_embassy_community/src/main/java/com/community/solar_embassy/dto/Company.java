package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Company implements Serializable {
    private Integer comNo;

    private String comName;

    private String address;

    private String parentName;

    private Date foundDate;

    private String founders;

    private String ceo;

    private String industries;

    private String slogan;

    private String content;

    private String comImgName;

    private String link;

    private static final long serialVersionUID = 1L;

    public Company(String comName, String address, String parentName, Date foundDate, String founders, String ceo, String industries, String slogan, String content, String comImgName) {
        this.comName = comName;
        this.address = address;
        this.parentName = parentName;
        this.foundDate = foundDate;
        this.founders = founders;
        this.ceo = ceo;
        this.industries = industries;
        this.slogan = slogan;
        this.content = content;
        this.comImgName = comImgName;
        this.link = link;
    }

    public Company() {
    }
}
