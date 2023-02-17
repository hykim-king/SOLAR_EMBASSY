package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BoardDto{
    private Integer boardNo;

    private Integer galaxyNo;

    private String userId;

    private Users user;

    private Integer boardTag;

    private String title;

    private String contents;

    private Date postTime;

    private String updaterId;

    private Date updateTime;

    private Integer state;

    private Integer likes;

    private Integer dislikes;

    private Integer views;

    private List<BoardImg> boardImgList;

    private List<Reply> replyList;

}