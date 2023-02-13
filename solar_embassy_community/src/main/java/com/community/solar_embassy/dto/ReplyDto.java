package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class ReplyDto implements Serializable {
    private String replyNo;

    private Integer boardNo;

    private String userId;

    private String fkReplyNo;

    private String contents;

    private Date postTime;

    private Date updateTime;

    private Integer likes;

    private Integer dislikes;

    private Integer state;

    private String imgPath;

    private String originImgName;

    private static final long serialVersionUID = 1L;
}