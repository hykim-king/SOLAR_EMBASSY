package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName reply
 */
@Data
public class Reply implements Serializable {
    private Integer replyNo;

    private Date postTime;

    private Integer boardNo;

    private String userId;

    private String fkReplyNo;

    private String contents;

    private Date updateTime;

    private Integer likes;

    private Integer dislikes;

    private Integer state;

    private String imgPath;

    private String originImgName;

    private static final long serialVersionUID = 1L;
}