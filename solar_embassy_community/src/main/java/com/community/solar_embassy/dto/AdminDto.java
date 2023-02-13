package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class AdminDto implements Serializable {
    private String adminId;

    private Integer adminLevel;

    private String department;

    private Date regTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}