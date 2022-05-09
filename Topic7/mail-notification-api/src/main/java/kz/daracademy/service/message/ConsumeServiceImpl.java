package kz.daracademy.service.message;

import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.EmailMessage;
import kz.daracademy.service.email.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    EmailSenderService emailSenderService;


    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeEmailInfo(ClientEmailInfo emailInfo) {
        EmailMessage emailMessage = emailSenderService.renderEmail(emailInfo);
        emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        log.info("Message: {} successfully consumed", emailInfo);
    }




}
