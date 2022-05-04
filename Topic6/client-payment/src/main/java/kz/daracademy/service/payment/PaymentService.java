package kz.daracademy.service.payment;

import kz.daracademy.model.PaymentRequest;
import kz.daracademy.model.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);

    PaymentResponse updatePayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentByPaymentId(String paymentId);

    Page<PaymentResponse> getAllPayments(Pageable pageable);

    List<PaymentResponse> getAllPaymentsList ();

    Page<PaymentResponse> getPaymentByClientId(String clientId, Pageable pageable);

    Page<PaymentResponse> getPaymentByPaymentType(String paymentType, Pageable pageable);

    void deletePaymentByPaymentId(String paymentId);


}
