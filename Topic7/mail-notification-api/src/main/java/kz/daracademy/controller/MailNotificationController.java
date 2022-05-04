package kz.daracademy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mails")
public class MailNotificationController {
    @GetMapping("/check")
    public String check() {
        return "mail-notification is working";
    }

}
