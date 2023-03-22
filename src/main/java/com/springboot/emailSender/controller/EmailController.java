package com.springboot.emailSender.controller;
import com.springboot.emailSender.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class EmailController {

    @Autowired
    EmailService emailService;

//    http://localhost:8080/app/sendMail
    @GetMapping("/sendMail")
    public String sendMail() throws AddressException {
        return emailService.sendMail();
    }

//    http://localhost:8080/app/SendAttachment
    @GetMapping("/SendAttachment")
   public String sendMailWithAttachment()  {
        return  emailService.sendMailWithAttachment();
    }

}
