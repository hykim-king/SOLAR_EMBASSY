package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PopularSearchDto implements Serializable {
    private Integer psNo;

    private String userId;

    private String crNum;

    private String buTell;

    private String psKeyword;

    private Date psDatetime;

    private String psIp;

    private static final long serialVersionUID = 1L;
}