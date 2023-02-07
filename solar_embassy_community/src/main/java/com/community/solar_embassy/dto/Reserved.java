package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Reserved implements Serializable {
    private Integer boNo;

    private Integer roNo;

    private Date boCkeckDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;
}