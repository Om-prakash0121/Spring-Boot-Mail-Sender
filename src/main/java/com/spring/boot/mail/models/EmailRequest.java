package com.spring.boot.mail.models;

import lombok.Data;

@Data
public class EmailRequest {
    
    private String titile;
    private String body;
    private String subject;
    private String recipantEmail;

}
