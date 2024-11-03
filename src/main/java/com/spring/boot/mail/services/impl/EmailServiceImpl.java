package com.spring.boot.mail.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.boot.mail.models.EmailRequest;
import com.spring.boot.mail.services.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendEmail(EmailRequest emailRequest) throws Exception {

        boolean state=false;

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        helper.setFrom("omprakashbehera625@gmail.com",emailRequest.getTitile());
        helper.setTo(emailRequest.getRecipantEmail());
        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getBody(),true);
        javaMailSender.send(mimeMessage);
        state=true;

        return state;
    }
    
}
