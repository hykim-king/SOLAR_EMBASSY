package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Galaxy implements Serializable {
    private Integer galaxyNo;

    private String adminId;

    private String galName;

    private Date regTime;

    private String updaterId;

    private Date updateTime;

    private Integer state;

    private List<BoardDto> boardDtoList;

    private static final long serialVersionUID = 1L;
}