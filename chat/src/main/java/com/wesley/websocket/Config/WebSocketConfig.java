/*
 * COPYRIGHT (c) ADOP 2021
 * This software is the proprietary of ADOP
 *
 * @author <a href=“mailto:wesley@adop.cc“>wesley</a>
 * @since 2021/04/13
 */
package com.wesley.websocket.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

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
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    // 클라이언트가 메시지를 구독할 endpoint를 정의합니다.
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/send");
    }

    @Override
    // connection을 맺을때 CORS 허용합니다.
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/").setAllowedOrigins("*").withSockJS();
    }
}
