package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName attend_check
 */
@Data
public class AttendCheck implements Serializable {
    private Integer checkNo;

    private Integer dayNo;

    private String userId;

    private Integer checkState;

    private Date checkTime;

    private Integer cPoint;

    private Integer ePoint;

    private static final long serialVersionUID = 1L;
}