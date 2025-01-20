package com.loltoulan.websocket_demo.onlySpringBoot;

import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
@Slf4j
public class MyInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        log.info("握手开始");
        String hostName = request.getRemoteAddress().getHostName();
        String sessionId = hostName + (int)(Math.random() * 1000);
        if (Strings.isNotBlank(sessionId)) {
            // 放入属性域
            attributes.put("session_id", sessionId);
            log.info("用户 session_id {} 握手成功！", sessionId);
            return true;
        }
        log.info("用户登录已失效");
        return false;
    }

    /**
     * 握手后
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        log.info("握手完成");
    }

}

