package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Planet {
    private Integer planetNo;

    private String title;

    private String userId;

    private String contents;

    private Date postDate;

    private Integer likes;

    private Integer dislikes;

    private Integer galaxyNo;

    private Integer views;

    private Integer state;

}