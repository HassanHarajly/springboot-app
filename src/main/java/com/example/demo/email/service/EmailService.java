package com.example.demo.email.service;
import com.example.demo.email.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class EmailService {


    private String recipientEmail;
    private Email emailContent;
    private String msg;
    private String subject;
    private JavaMailSender emailSender;
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("springboot5478@gmail.com");
        mailSender.setPassword("GudPassword!");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


public String getHTML()
{
    StringBuilder contentBuilder = new StringBuilder();
    try{
        BufferedReader in = new BufferedReader(new FileReader("src/main/java/com/example/demo/email-assets/email.html"));
        String tmp;
        while((tmp=in.readLine()) !=null)
        {
            contentBuilder.append(tmp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return contentBuilder.toString();
}
    public void sendMessageWithAttachment() {
        try{
        emailSender = getJavaMailSender();
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("springboot5478@gmail.com");
        helper.setTo(emailContent.getRecipient());
        helper.setSubject(emailContent.getSubject());

        helper.setText(getHTML(),true);

        FileSystemResource file
                = new FileSystemResource(new File("src/main/java/com/example/demo/email-assets/HASSAN RESUME.docx"));
        helper.addAttachment("hassansResume.docx", file);

        emailSender.send(message);
        }   catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public void setEmailContent(Email emailContent) {
        this.emailContent=emailContent;
    }
}
