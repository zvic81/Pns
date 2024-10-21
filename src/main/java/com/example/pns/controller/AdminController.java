package com.example.pns.controller;

import com.example.pns.MessageService;
import com.example.pns.model.PnsMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    private final MessageService messageService;
    private static List<PnsMessage> messages;

    public AdminController(MessageService messageService) {
        this.messageService = messageService;
        messages = messageService.getAllMessages();
    }

    @GetMapping("/admin/edit_messages")
    public String showEditMessagePage(Model model){
        messages = messageService.getAllMessages();
        model.addAttribute("messages", messages);
        return "edit_messages";
    }

    @PostMapping("/admin/edit_messages")
    public String saveEditMessagePage(@RequestParam("messages") List<String> updatedMessages){

        if (!updatedMessages.isEmpty())
            messageService.clearAllMessages();
        for (String s : updatedMessages){
            PnsMessage pnsMessage = new PnsMessage(s, java.time.LocalDateTime.now(), "user1");
            messageService.addMessage(pnsMessage);
        }

        return "redirect:/admin/edit_messages";
    }


}
