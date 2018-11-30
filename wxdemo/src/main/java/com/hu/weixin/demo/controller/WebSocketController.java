package com.hu.weixin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

/**
 * @Date: 2018/11/28 14:54
 * @Author: huwl
 * @Description:
 */
@Controller
public class WebSocketController {
    @Autowired
    public SimpMessagingTemplate template;

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public String greeting(String message) throws Exception {
        return message;
    }

    @MessageMapping("/message")
    @SendToUser("/message")
    public String userMessage(String userMessage) throws Exception {
        return userMessage;
    }
}
