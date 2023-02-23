package community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BoardDto implements Serializable {
    private Integer boardNo;

    private Date postTime;

    private Integer galaxyNo;

    private String userId;

    private Integer boardTag;

    private String title;

    private String contents;

    private String updaterId;

    private Date updateTime;

    private Integer state;

    private Integer likes;

    private Integer dislikes;

    private Integer views;

    private static final long serialVersionUID = 1L;
}

