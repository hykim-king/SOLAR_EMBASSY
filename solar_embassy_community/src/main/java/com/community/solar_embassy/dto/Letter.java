package com.community.solar_embassy.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName letter
 */
@Data
public class Letter implements Serializable {
    private Integer letterNo;

    private String senderId;

    private String receiverId;

    private String title;

    private String contents;

    private Date sentTime;

    private Date readTime;

    private Integer receiveState;

    private String receiverName;

    private String senderName;

    private static final long serialVersionUID = 1L;
}