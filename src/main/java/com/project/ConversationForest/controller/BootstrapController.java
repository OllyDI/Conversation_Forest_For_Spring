package com.project.ConversationForest.controller;

import com.project.ConversationForest.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class BootstrapController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        System.out.println(session);
        if (session == null) return "members/login";
        else return "index";
    }
}
