package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDto{
    private Integer boardNo;

    private Integer galaxyNo;

    private String userId;

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

}