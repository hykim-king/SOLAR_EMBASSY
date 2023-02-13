package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UserBlockDto implements Serializable {
    private Integer blockNo;

    private String userId;

    private String blockObjId;

    private String reason;

    private Date postTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}