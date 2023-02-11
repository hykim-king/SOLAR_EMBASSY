package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Booking implements Serializable {
    private Integer boNo;

    private String crNum;

    private String buTell;

    private Integer roNo;

    private String userId;

    private String buAddress;

    private Date rdStartDate;

    private Date rdEndDate;

    private String userName;

    private String userPhone;

    private Date boDate;

    private Date ckeckin;

    private Date checkout;

    private String payment;

    private String price;

    private Date regDate;

    private Integer state;

    private String buCheck;

    private String updaterId;

    private Date updateDate;

    private static final long serialVersionUID = 1L;
}