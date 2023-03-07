package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName admin
 */
@Data
public class Admin implements Serializable {
    private String adminId;

    private Integer adminLevel;

    private String department;
    private Date regTime;
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Admin() {
    }

    public Admin(String adminId, Integer adminLevel, String department) {
        this.adminId = adminId;
        this.adminLevel = adminLevel;
        this.department = department;
    }
}