package kz.daracademy.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom("sharipaigul@gmail.com");
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);

        mailSender.send(email);

        System.out.println("Mail Sent Succesfully ...");

    }


}
