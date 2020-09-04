package com.example.demo.email.api;

import com.example.demo.email.model.Email;
import com.example.demo.email.service.EmailService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/email")
@RestController
public class EmailController {
    private EmailService emailService = new EmailService();





    @PostMapping(path = "email")
    public void SendEmail( @RequestBody @Valid @NonNull Email emailObject) {

        try {

            emailService.setEmailContent(emailObject);
            emailService.sendMessageWithAttachment();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
