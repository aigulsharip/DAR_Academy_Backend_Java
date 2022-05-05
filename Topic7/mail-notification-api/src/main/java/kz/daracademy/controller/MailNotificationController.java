package kz.daracademy.controller;

import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.EmailMessage;
import kz.daracademy.service.email.EmailSenderService;
import kz.daracademy.service.message.ConsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

@RestController
@RequestMapping("/email")
@Slf4j
public class MailNotificationController {

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    ConsumeService consumeService;



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
