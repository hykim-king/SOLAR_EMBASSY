package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ReviewDto implements Serializable {
    private Integer reNo;

    private Integer boNo;

    private String userId;

    private String contents;

    private Integer state;

    private Integer likes;

    private Date postTime;

    private Date updateTime;

    private String contentReply;

    private Date replyPostDate;

    private Date replyUpdateDate;

    private static final long serialVersionUID = 1L;
}