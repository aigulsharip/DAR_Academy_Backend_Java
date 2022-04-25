package kz.daracademy.service;

import kz.daracademy.model.PaymentRequest;
import kz.daracademy.model.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse updatePayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentByPaymentId(String paymentId);
    Page<PaymentResponse> getAllPayments(Pageable pageable);

    Page<PaymentResponse> getPaymentByClientId(String clientId, Pageable pageable);

    Page<PaymentResponse> getPaymentByPostId(String postId, Pageable pageable);

    void deletePaymentByPaymentId(String paymentId);


}
