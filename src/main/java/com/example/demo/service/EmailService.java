package com.example.demo.service;

import com.lowagie.text.Image;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text,String url ) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom("oont276@gmail.com");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);


            String mailContent =
                    "<p>"+text +"</p><hr>  <button > <a href='"+url+"'> voir plus</a></button>";


            messageHelper.setText(mailContent,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace(); // or log the error
        }
    }
}
