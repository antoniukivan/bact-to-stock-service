package com.example.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String userName;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private String port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String isSmtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String isSmtpStarttlsEnable;

    @Value("${mail.debug}")
    private String isDebug;

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(userName);
        mailSender.setPassword(password);
        mailSender.setPort(Integer.parseInt(port));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", protocol);
        props.put("mail.smtp.auth", isSmtpAuth);
        props.put("mail.smtp.starttls.enable", isSmtpStarttlsEnable);
        props.put("mail.debug", isDebug);

        return mailSender;
    }
}
