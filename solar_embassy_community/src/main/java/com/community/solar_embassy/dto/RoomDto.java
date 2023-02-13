package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class RoomDto implements Serializable {
    private Integer roNo;

    private String crNum;

    private String buTell;

    private Integer buImgNo;

    private String roCount;

    private String roName;

    private String roPrice;

    private Date checkin;

    private Date checkout;

    private String roInfo;

    private Date postTime;

    private String updaterId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}