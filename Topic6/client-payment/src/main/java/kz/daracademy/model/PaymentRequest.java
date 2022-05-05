package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String paymentId;

    private String clientId;

    private String paymentType;

    private Integer amount;

    private LocalDate paymentDate;

}
