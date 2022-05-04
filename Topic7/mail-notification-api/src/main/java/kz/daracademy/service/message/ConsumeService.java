package kz.daracademy.service.message;


import kz.daracademy.model.PaymentResponse;

public interface ConsumeService {
    void consumeMessage(PaymentResponse message);
}
