package com.spring.boot.mail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mail.models.EmailRequest;
import com.spring.boot.mail.services.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    private ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest);
            return new ResponseEntity<>("Email sent sucessfully",HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
