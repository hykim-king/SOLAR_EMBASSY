package com.community.solar_embassy.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BoardDto implements Serializable {
    private Integer boardNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
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

    private Integer likes;

    private Integer dislikes;
    private BoardPreferViewDto boardPreferView;

    private int views;

    private BoardImg boardImg;
    private List<Reply> replyList;

    private static final long serialVersionUID = 1L;
}