package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
public class AttendCheck implements Serializable {
    private Integer dayNo;

    private String userId;

    private Integer checkState;

    private Date checkTime;

    private Integer cPoint;

    private Integer ePoint;

    private static final long serialVersionUID = 1L;
}