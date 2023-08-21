package com.lms.librarymanagementsystem.services;

// import java.io.File;
// import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
// import org.springframework.mail.MailException;
// import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

// import jakarta.activation.DataHandler;
// import jakarta.activation.DataSource;
// import jakarta.activation.FileDataSource;
// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeBodyPart;
// import jakarta.mail.internet.MimeMessage;
// import jakarta.mail.internet.MimeMultipart;

@Configuration
@Service
@EnableAsync
public class EmailServices {
    @Autowired
    private JavaMailSender javaMailSender;
    // @Autowired
    // private MailSender mailSender;

    @Async
    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("libraryauthorities2023@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }

  /*   @Async
    public void sendMimeMail(String to, String subject, String body, File file) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("libraryauthorities2023@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);

            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(body);
            multipart.addBodyPart(bodyPart);

            if (file != null) {
                DataSource dataSource = new FileDataSource(file);
                MimeBodyPart attachment = new MimeBodyPart();
                attachment.setDataHandler(new DataHandler(dataSource));
                attachment.setFileName(file.getName());
                // MimeMultipart multipart = new MimeMultipart();
                multipart.addBodyPart(attachment);
            }
            
            message.setContent(multipart);
            javaMailSender.send(message);
        } catch (MessagingException | MailException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void sendMediaMail(String to, String subject, String body, String imageData) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("libraryauthorities2023@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
    
            // Create the message body
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(body, "text/html");
            multipart.addBodyPart(messageBodyPart);
    
            // Add the image as a Base64-encoded string to the message body
            MimeBodyPart imagePart = new MimeBodyPart();
            // byte[] imageBytes = Files.readAllBytes(Paths.get(imageData));
            // String encodedImage = Base64.getEncoder().encodeToString(imageBytes);
            imagePart.setContent("<img src=\"" + imageData + "\" />", "text/html");
            multipart.addBodyPart(imagePart);
    
            // Set the message content to the multipart message
            message.setContent(multipart);
    
            // Send the message
            javaMailSender.send(message);
        } catch (MessagingException | MailException e) {
            e.printStackTrace();
        }
    } */
}
