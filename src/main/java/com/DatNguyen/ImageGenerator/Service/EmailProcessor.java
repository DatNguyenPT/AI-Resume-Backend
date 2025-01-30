package com.DatNguyen.ImageGenerator.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailProcessor{
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${email}")
    private String from;
    public void sendOTP(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        String otp = String.valueOf(otpGenerator());
        String subject = "Account verification email";
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(otp);
        javaMailSender.send(message);
    }

    private int otpGenerator() {
        return (int) (Math.random() * 10000);
    }
}
