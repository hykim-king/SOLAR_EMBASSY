package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName review
 */
@Data
public class Review implements Serializable {
    private Integer reNo;

    private Date postTime;

    private Integer bokNo;

    private String userId;

    private String contents;

    private Integer state;

    private Integer likes;

    private String buComment;

    private String updaterId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}