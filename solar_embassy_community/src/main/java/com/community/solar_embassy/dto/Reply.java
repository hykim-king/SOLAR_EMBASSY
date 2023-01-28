package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Reply  {
    private String replyNo;

    private Integer planetNo;

    private String fkReplyNo;

    private String userId;

    private String contents;

    private Date postTime;

    private Integer likes;

    private Integer dislikes;

    private Integer state;

}