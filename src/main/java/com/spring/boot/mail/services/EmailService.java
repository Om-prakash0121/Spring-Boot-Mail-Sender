package com.spring.boot.mail.services;

import org.springframework.stereotype.Service;

import com.spring.boot.mail.models.EmailRequest;

@Service
public interface EmailService {
    public boolean sendEmail(EmailRequest emailRequest) throws Exception;
}
