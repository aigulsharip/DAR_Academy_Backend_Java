package kz.daracademy.service.send;

import kz.daracademy.model.PaymentResponse;

public interface SendService {
    void send(PaymentResponse paymentResponse);
}
