package kz.daracademy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kz.daracademy.feign.ClientFeign;
import kz.daracademy.model.*;
import kz.daracademy.service.message.SendService;
import kz.daracademy.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ClientFeign clientFeign;

    @Autowired
    private SendService sendService;

    ObjectMapper objectMapper = new ObjectMapper();



    @GetMapping("/check")
    public String check() {
        return "client-payment-api is working ";
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

    @GetMapping("/totalPayments")
    public ClientTotal getTotal (@RequestParam String clientId) {
        List<PaymentResponse> allPayments = paymentService.getAllPaymentsList();
        ClientResponse client = clientFeign.getClientById(clientId);
        HashMap<String, Integer> allPaymentsMap = new HashMap<>();
        int sum = 0;
        int numberOfPayments = 0;
        for (PaymentResponse payment: allPayments) {
            if (payment.getClientId().equals(clientId) ) {
                sum += payment.getAmount();
                numberOfPayments++;
            }
        }
        return new ClientTotal(clientId, client, sum, numberOfPayments);
    }


    @PostMapping("/send-payment")
    public PaymentResponse sendPaymentToKafka(@RequestBody PaymentRequest paymentRequest) throws JsonProcessingException {
        PaymentResponse paymentResponse = paymentService.createPayment(paymentRequest);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        sendService.send(objectMapper.writeValueAsString(paymentResponse));
        return paymentResponse;
    }

    @GetMapping("/send-email")
    public ClientEmailInfo sendClientData(@RequestParam String clientId) throws JsonProcessingException {
        List<PaymentResponse> allPayments = paymentService.getAllPaymentsList();
        ClientResponse client = clientFeign.getClientById(clientId);
        int sum = 0;
        for (PaymentResponse payment: allPayments) {
            if (payment.getClientId().equals(clientId) ) {
                sum += payment.getAmount();
            }
        }
        ClientEmailInfo clientEmailInfo = new ClientEmailInfo();
        clientEmailInfo.setTotalPaymentId(UUID.randomUUID().toString());
        clientEmailInfo.setClientName(client.getName() + " " + client.getSurname());
        clientEmailInfo.setClientEmail(client.getEmail());
        clientEmailInfo.setTotalPaymentsAmount(sum);
        sendService.send(objectMapper.writeValueAsString(clientEmailInfo));

        return clientEmailInfo;



    }











}
