package com.email.controller;

import com.email.model.Email;
import com.email.model.EmailResponse;
import com.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    //send email api
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody Email email){
        System.out.println(email);
        boolean result = this.emailService.sendEmail(email.getSubject() , email.getMessage(), email.getTo());
        if (result){
            return ResponseEntity.ok(new EmailResponse("Email Sent Successfully...."));
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Sent"));
        }

    }

}
