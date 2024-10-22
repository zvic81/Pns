package com.example.pns.controller;

import com.example.pns.MessageService;
import com.example.pns.model.PnsMessage;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String showNotification(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        int pageSize = 3;
        List<PnsMessage> pnsMessages = messageService.getAllMessages();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, pnsMessages.size());
        List<PnsMessage> messagesPage = pnsMessages.subList(fromIndex, toIndex);
        model.addAttribute("messages", messagesPage);
        model.addAttribute("totalPages", (pnsMessages.size() + pageSize - 1) / pageSize);
        model.addAttribute("currentPage", page);
        return "notification";
    }

}
