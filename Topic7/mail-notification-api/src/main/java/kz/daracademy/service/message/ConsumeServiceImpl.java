package kz.daracademy.service.message;

import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.EmailMessage;
import kz.daracademy.model.PaymentResponse;
import kz.daracademy.service.email.EmailSenderService;
import kz.daracademy.service.send.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private SendService sendService;

    @Autowired
    EmailSenderService emailSenderService;


    /*
    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeMessage(PaymentResponse message) {
        log.info("Message: {} successfully consumed", message);
        //sendService.send(message);
    }

     */


    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeEmailInfo(ClientEmailInfo emailInfo) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(emailInfo.getClientEmail());
        emailMessage.setClientName(emailInfo.getClientName());
        emailMessage.setSubject("Payment receipt # " + emailInfo.getTotalPaymentId());
        emailMessage.setMessage("Customer "+ emailInfo.getClientName() + " has successfully paid for receipt # " + emailInfo.getTotalPaymentId() +
                        ". The total amount of payment was " + emailInfo.getTotalPaymentsAmount() + " tenge.");

        log.info("Message: {} successfully consumed", emailInfo);

        emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());



    }




}
