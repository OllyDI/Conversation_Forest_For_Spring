package com.project.ConversationForest.controller;

import com.project.ConversationForest.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@Slf4j
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/sendMail")
    public ResponseEntity<Boolean> sendMimeMessage(@RequestBody Map<String, Object> postData) {
        boolean res = mailService.sendMimeMessage((String) postData.get("email"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}