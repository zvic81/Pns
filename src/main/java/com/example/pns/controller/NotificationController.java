package com.example.pns.controller;

import com.example.pns.MessageService;
import com.example.pns.model.PnsMessage;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController {
    private final MessageService messageService;

    public NotificationController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String HomePage(){

        return "home";
    }

    @GetMapping("/notifications")
    public String showNotification(Model model){
        List<PnsMessage> pnsMessages = messageService.getAllMessages();
        model.addAttribute("messages", pnsMessages);
        return "notification";
    }

}
