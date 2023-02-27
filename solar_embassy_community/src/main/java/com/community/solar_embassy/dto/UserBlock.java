package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName user_block
 */
@Data
public class UserBlock implements Serializable {
    private Integer blockNo;

    private String userId;

    private String blockObjId;

    private String reason;

    private Date postTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}