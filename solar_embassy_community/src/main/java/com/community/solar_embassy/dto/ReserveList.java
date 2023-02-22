package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName reserve_list
 */
@Data
public class ReserveList implements Serializable {
    private Integer listNo;

    private Date bokCheckDate;

    private Integer bokNo;

    private String buTell;

    private String updaterId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}