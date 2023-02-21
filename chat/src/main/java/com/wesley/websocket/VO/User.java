/*
 * COPYRIGHT (c) ADOP 2021
 * This software is the proprietary of ADOP
 *
 * @author <a href=“mailto:wesley@adop.cc“>wesley</a>
 * @since 2021/04/13
 */
package com.wesley.websocket.VO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * create on 2021/04/13.
 * create by IntelliJ IDEA.
 *
 * <p> 클래스 설명 </p>
 * <p> {@link } and {@link }관련 클래스 </p>
 *
 * @author wesley
 * @version 1.0
 * @see
 * @since 지원하는 자바버전 (ex : 5+ 5이상)
 */
@Data
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
    private String content;
    private String sendDate;
    private String isRead;

    public User(String userName, String content) {
        this.userName=userName;
        this.content=content;
    }
}
