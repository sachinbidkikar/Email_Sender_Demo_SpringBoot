package com.springboot.emailSender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public String sendMail() throws AddressException {
        String fromAddress = "Spring Email Project <sachin@gmail.com>";

        SimpleMailMessage emailMessage = new SimpleMailMessage();

        emailMessage.setFrom(String.valueOf(new InternetAddress(fromAddress)));
        emailMessage.setTo("reach.sachin@gmail.com");
        emailMessage.setSubject("Test Mail in Subject");
        emailMessage.setText("Test Mail in Body");

//        emailMessage.setTo("reach.sachin@gmail.com", "hire.sachin@gmail.com");
//        emailMessage.setBcc("hire.sachin@gmail.com");

        javaMailSender.send(emailMessage);

        return "Mail sent Successfully";
    }

    public String sendMailWithAttachment() {

        String fromAddress = "Spring Email Project <sachin@gmail.com>";
        File filePath = new File("SpringBoot_Email_Sender\\src\\main\\resources\\TestAttachment.txt");
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(String.valueOf(new InternetAddress(fromAddress)));
            messageHelper.setTo("reach.sachin@gmail.com");
            messageHelper.setSubject("Test Attachment Mail in Subject");
            messageHelper.setText("Test Mail with Attachment");
            messageHelper.addAttachment(filePath.getName(), filePath);

            javaMailSender.send(message);

            return "Mail Sent with Attachment";
        }
        catch (Exception e)
        {
            return "Mail Not sent " + e;
        }
    }
}
