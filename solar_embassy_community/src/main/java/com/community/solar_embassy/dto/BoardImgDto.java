package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class BoardImgDto implements Serializable {
    private String boardImgNo;

    private Integer boardNo;

    private String imagePath;

    private String originImgName;

    private Date postTime;

    private static final long serialVersionUID = 1L;
}