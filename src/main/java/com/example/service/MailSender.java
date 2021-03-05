package com.example.service;

public interface MailSender {
    void send(String emailTo, String subject, String text);
}
