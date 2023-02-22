package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName room_img
 */
@Data
public class RoomImg implements Serializable {
    private Integer imgNo;

    private String buTell;

    private String imgPath;

    private String sourceImgName;

    private String saveImgName;

    private Date postTime;

    private static final long serialVersionUID = 1L;
}