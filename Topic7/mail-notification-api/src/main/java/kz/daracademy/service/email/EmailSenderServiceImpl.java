package kz.daracademy.service.email;

import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public EmailMessage renderEmail(ClientEmailInfo emailInfo) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(emailInfo.getClientEmail());
        emailMessage.setClientName(emailInfo.getClientName());
        emailMessage.setSubject("Payment receipt #" + emailInfo.getTotalPaymentId());

        String message = " Customer " + emailInfo.getClientName() + " has successfully paid for receipt #" + emailInfo.getTotalPaymentId() + ". \n";
        message += " Paid services: \n";

        HashMap<String, Integer> clientsPayments = emailInfo.getClientPayments();
        for (Map.Entry<String, Integer> payment : clientsPayments.entrySet()) {
            message += "    " + payment.getKey() + " - " + payment.getValue() + " tenge \n";
        }
        message += " The total amount of payment was " + emailInfo.getTotalPaymentsAmount() + " tenge.";
        emailMessage.setMessage(message);
        return emailMessage;
        //emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());


    }


}
