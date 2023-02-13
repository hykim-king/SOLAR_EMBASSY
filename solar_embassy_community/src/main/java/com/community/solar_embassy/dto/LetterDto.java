package com.community.solar_embassy.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class LetterDto implements Serializable {
    private Integer letterNo;

    private String senderId;

    private String receiverId;

    private String title;

    private String contents;

    private Date sentTime;

    private Date readTime;

    private Integer receiveState;

    private Integer receiverDel;

    private Integer senderDel;

    private static final long serialVersionUID = 1L;
}