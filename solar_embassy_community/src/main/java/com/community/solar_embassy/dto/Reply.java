package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @TableName reply
 */
@Data
public class Reply implements Serializable {
    private Integer replyNo;

    private Date postTime;

    private Integer boardNo;

    private String userId;
    private Users user;

    private String nickname;

    private Integer fkReplyNo;

    private String contents;

    private Date updateTime;

    private Integer likes;

    private Integer dislikes;

    private Integer state;

    private String imgPath;

    private String originImgName;

    private List<Reply> reReplyList;

    private static final long serialVersionUID = 1L;

    public Reply() {

    }

    public Reply(Integer replyNo, Integer boardNo, String userId, String contents) {
        this.replyNo = replyNo;
        this.boardNo = boardNo;
        this.userId = userId;
        this.contents = contents;
    }
}