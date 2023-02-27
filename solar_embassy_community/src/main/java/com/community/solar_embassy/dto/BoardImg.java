package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName board_img
 */
@Data
public class BoardImg implements Serializable {
    private Integer boardImgNo;

    private Integer boardNo;

    private String imagePath;

    private String originImgName;

    private Date postTime;

    private static final long serialVersionUID = 1L;
}