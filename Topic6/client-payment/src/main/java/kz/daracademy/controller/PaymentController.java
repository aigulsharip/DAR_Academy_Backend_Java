package kz.daracademy.controller;

import kz.daracademy.feign.ClientFeign;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PaymentDetails;
import kz.daracademy.model.PaymentRequest;
import kz.daracademy.model.PaymentResponse;
import kz.daracademy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ClientFeign clientFeign;


    @GetMapping("/check")
    public String check() {
        return "client-payment-api is working at the port";
    }


    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @PutMapping
    public PaymentResponse updatePayment(@RequestParam String paymentId, @RequestBody PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(paymentId);
        return paymentService.updatePayment(paymentRequest);
    }


    @GetMapping("/all")
    public Page<PaymentResponse> getAllPayments(Pageable pageable) {
        return paymentService.getAllPayments(pageable);
    }

    @GetMapping()
    public PaymentResponse getAllPaymentByPaymentId(@RequestParam String paymentId) {
        return paymentService.getPaymentByPaymentId(paymentId);
    }

    @GetMapping("/client")
    public Page<PaymentResponse> getPaymentByClientId(@RequestParam String clientId, Pageable pageable) {
        return paymentService.getPaymentByClientId(clientId, pageable);
    }

    @GetMapping("/type")
    public Page<PaymentResponse> getPaymentByPaymentType(@RequestParam String paymentType, Pageable pageable) {
        return paymentService.getPaymentByPaymentType(paymentType, pageable);
    }

    @DeleteMapping
    public void deleteByPaymentId(@RequestParam String paymentId) {
        paymentService.deletePaymentByPaymentId(paymentId);
    }

    @GetMapping("/details")
    public PaymentDetails getPaymentDetails(@RequestParam String paymentId) {
        PaymentResponse payment = paymentService.getPaymentByPaymentId(paymentId);
        ClientResponse client = clientFeign.getClientById(payment.getClientId());
        return new PaymentDetails(paymentId, client, payment.getPaymentType(), payment.getAmount(), payment.getPaymentDate());

    }

}
