package com.example.pns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    private static List<String> messages = new ArrayList<>();
    static {
        messages.add("Test1 message");
        messages.add("Test111 message. Tomcat started on port 8080 (http) with context path '/' 2024-10-09T13:23:44.137+03:00  INFO 293062 --- [Pns] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1425 ms");
        messages.add("Test222 message");
        messages.add("Test3 message. Starting Servlet engine: [Apache Tomcat/10.1.30]. Initializing Servlet 'dispatcherServlet'");
    }
    @GetMapping("/admin/edit_messages")
    public String showEditMessagePage(Model model){
        model.addAttribute("messages", messages);
        return "edit_messages";
    }

    @PostMapping("/admin/edit_messages")
    public String saveEditMessagePage(@RequestParam("messages") List<String> updatedMessages){
        messages = updatedMessages;
        return "redirect:/admin/edit_messages";
    }


}
