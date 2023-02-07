package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Board implements Serializable {
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

    private static final long serialVersionUID = 1L;
}