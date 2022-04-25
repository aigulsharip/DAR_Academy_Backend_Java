package kz.daracademy.controller;

import kz.daracademy.model.PaymentRequest;
import kz.daracademy.model.PaymentResponse;
import kz.daracademy.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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
    public Page<PaymentResponse> getPaymentByClientId (@RequestParam String clientId, Pageable pageable) {
        return paymentService.getPaymentByClientId(clientId, pageable);
    }

    @GetMapping("/post")
    public Page<PaymentResponse> getPaymentByPostId (@RequestParam String postId, Pageable pageable) {
        return paymentService.getPaymentByPostId(postId, pageable);
    }

    @DeleteMapping
    public void deleteByPaymentId (@RequestParam String paymentId) {
        paymentService.deletePaymentByPaymentId(paymentId);

    }




}
