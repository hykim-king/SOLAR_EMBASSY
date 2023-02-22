package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName galaxy
 */
@Data
public class Galaxy implements Serializable {
    private Integer galaxyNo;

    private String adminId;

    private String galName;

    private Date regTime;

    private String updaterId;

    private Date updateTime;

    private Integer state;

    private static final long serialVersionUID = 1L;
}