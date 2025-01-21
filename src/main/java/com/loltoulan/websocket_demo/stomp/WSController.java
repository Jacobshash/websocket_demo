package com.loltoulan.websocket_demo.stomp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WSController {
    
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/greeting")
    @SendToUser("/queue/serverReply")
    public String greating(@Payload String data) {
        log.info("received greeting: {}", data);
        String msg = "server replys: " + data;
        log.info("server replys: {}", data);
        return msg;
    }

    @MessageMapping("/shout")
    public void userShout(Shout shout) {
        // String name = principal.getName();
        String message = shout.getMessage();
        log.info("收到的消息是：{}", message);
        simpMessagingTemplate.convertAndSend("/queue/notifications", shout);

    }

}

