package kz.daracademy.service.email;

import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.EmailMessage;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
    EmailMessage renderEmail(ClientEmailInfo emailInfo);
}
