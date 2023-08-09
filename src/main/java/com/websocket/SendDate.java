package com.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

@Component
public class SendDate {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public SendDate(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }
    @Scheduled(fixedDelay = 5000L)
    public void  getTime(){
        Date date = new Date();
        simpMessagingTemplate.convertAndSend("/topic/date",date);
    }

    public void type(){
        simpMessagingTemplate.convertAndSend("/topic/typing", "typing");
    }
    public void online(){
        simpMessagingTemplate.convertAndSend("/topic/online", "online");
    }
}
