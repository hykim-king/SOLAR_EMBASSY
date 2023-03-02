package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName board
 */
@Data
public class BoardDto implements Serializable {
    private Integer boardNo;

    private Date postTime;

    private Integer galaxyNo;
    private Galaxy galaxy;

    private String userId;
    private Users user;


    private Integer boardTag;

    private String title;

    private String contents;

    private String updaterId;

    private Date updateTime;

    private Integer state;

    private int likes;

    private int dislikes;

    private BoardPreferViewDto boardPreferView;

    private int views;

    private static final long serialVersionUID = 1L;
}