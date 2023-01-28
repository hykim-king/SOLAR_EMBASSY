package com.community.solar_embassy.dto;

import lombok.Data;

import java.util.Date;
@Data
public class Letter   {
    private Integer letterNo;

    private String senderId;

    private String receiverId;

    private String title;

    private String contents;

    private Date sentDate;

    private Date readDate;

    private Integer receiveState;

    private Integer receiverDel;

    private Integer senderDel;

}