package com.DatNguyen.AuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${email}")
    private String from;
    public String sendOTP(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        String otp = String.valueOf(otpGenerator());
        String subject = "Account verification email";
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(otp);

        try{
            javaMailSender.send(message);
        }catch(MailSendException ex){
            System.out.println(ex.getMessage());
        }

        return otp.toString();
    }

    private int otpGenerator() {
        return (int) (Math.random() * 10000);
    }
}
