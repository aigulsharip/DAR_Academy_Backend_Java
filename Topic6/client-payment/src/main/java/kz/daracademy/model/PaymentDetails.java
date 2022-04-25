package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDetails {

    private String paymentId;

    private ClientResponse client;

    private String paymentType;

    private Integer amount;

    private LocalDate paymentDate;



}
