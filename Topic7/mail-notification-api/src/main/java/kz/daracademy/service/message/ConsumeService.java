package kz.daracademy.service.message;


import kz.daracademy.model.ClientEmailInfo;
import kz.daracademy.model.PaymentResponse;

public interface ConsumeService {
    //void consumeMessage(PaymentResponse message);
    void consumeEmailInfo(ClientEmailInfo emailInfo);
}
