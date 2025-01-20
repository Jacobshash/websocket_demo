package com.loltoulan.websocket_demo.springbootAndNative;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/loltoulanWs")
@Slf4j
public class WebSocketServerEndpoint {

    /**
     * 连接成功
     * @param session
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("session id is {} ,连接成功", session.getId());
        log.info("连接成功");
    }

    /**
     * 连接关闭
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        log.info("session id is {} ,连接关闭", session.getId());
        log.info("连接关闭");
    }

    /**
     * 接收到消息
     * @param text
     */
    @OnMessage
    public String onMsg(String text,Session session) {
        log.info("servet {}, 接收到消息：{}",session.getId(), text);
        return "servet 发送：" + text;
    }

}
