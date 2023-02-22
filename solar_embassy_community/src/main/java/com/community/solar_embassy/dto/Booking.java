package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName booking
 */
@Data
public class Booking implements Serializable {
    private Integer bokNo;

    private Date bookingDate;

    private String buTell;

    private Integer buNo;

    private String userId;

    private String userName;

    private String userPhone;

    private String address;

<<<<<<< HEAD
=======
    private Date startDate;

    private Date endDate;

>>>>>>> 69a5ab68b59c6e2c9478a29653c95fb104023b62
    private Date checkin;

    private Date checkout;

    private String payment;

    private String price;

    private Date payDate;

    private Integer state;

    private String bokCheck;

    private String updaterId;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}