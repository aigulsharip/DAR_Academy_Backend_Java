package kz.daracademy.service.send;

import kz.daracademy.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class SendServiceImpl implements SendService {

    @Override
    public void send(PaymentResponse paymentResponse) {
        System.out.println(paymentResponse);
    }
}
