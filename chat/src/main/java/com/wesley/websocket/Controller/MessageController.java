/*
 * COPYRIGHT (c) ADOP 2021
 * This software is the proprietary of ADOP
 *
 * @author <a href=“mailto:wesley@adop.cc“>wesley</a>
 * @since 2021/04/13
 */
package com.wesley.websocket.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
@Controller
@ServerEndpoint("/websocket")
public class MessageController extends Socket {
    private static final List<Session> session = new ArrayList<Session>();

    public MessageController() {
//        this.isSessionClosed();
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println("현재 접속중인 유저 수 : " + session.size());
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        for (int i = 0; i < session.size(); i++) {
            if (! recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText("유저" + (Integer.parseInt(session.get(i).getId()) + 1) + " : " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    session.get(i).getBasicRemote().sendText("나 : " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Scheduled(cron = "* * * * * *")
    private void isSessionClosed() {
        if (session.size() != 0) {
            try {
                System.out.println("! = " + session.size());
                for (int i = 0; i < session.size(); i++) {
                    if (! session.get(i).isOpen()) {
                        session.remove(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}