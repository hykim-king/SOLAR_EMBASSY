package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName business
 */
@Data
public class Business implements Serializable {
    private Integer buNo;

    private String buId;

    private String buPasswords;

    private String buName;

    private String email;

    private String phone;

    private Date regDate;

    private Date updateTime;

    private Integer state;

    private Integer auth;

    private static final long serialVersionUID = 1L;
}