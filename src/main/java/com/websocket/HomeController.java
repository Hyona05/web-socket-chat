package com.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final SendDate sendDate;

    public HomeController(SendDate sendDate) {
        this.sendDate = sendDate;
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/message")
    public String message(){
        return "message";
    }

    @MessageMapping("/typing")
    public void type(){
     sendDate.type();
    }

    @MessageMapping("/online")
    public void online(){
        sendDate.online();
    }
}
