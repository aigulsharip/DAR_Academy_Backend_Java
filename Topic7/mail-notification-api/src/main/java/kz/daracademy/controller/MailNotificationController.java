package kz.daracademy.controller;

import kz.daracademy.model.EmailMessage;
import kz.daracademy.service.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class MailNotificationController {

    @Autowired
    EmailSenderService emailSenderService;


    @GetMapping("/check")
    public String check() {
        return "mail-notification is working";
    }


    @PostMapping("/send")
    public ResponseEntity sendEmail (@RequestBody EmailMessage emailMessage) {

        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());

        return ResponseEntity.ok("Mail Send Succesfully");
    }


}
