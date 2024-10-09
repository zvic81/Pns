package com.example.pns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String HomePage(){

        return "home";
    }

    @GetMapping("/notifications")
    public String showNotification(Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = LocalDateTime.now().format(formatter);
        model.addAttribute("currentTime", currentTime);
        List<String> messages = new ArrayList<>();
        messages.add("Test1 message");
        messages.add("Test111 message. Tomcat started on port 8080 (http) with context path '/' 2024-10-09T13:23:44.137+03:00  INFO 293062 --- [Pns] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1425 ms");
        messages.add("Test222 message");
        messages.add("Test3 message. Starting Servlet engine: [Apache Tomcat/10.1.30]. Initializing Servlet 'dispatcherServlet'");
        model.addAttribute("messages", messages);
        return "notification";
    }
}
