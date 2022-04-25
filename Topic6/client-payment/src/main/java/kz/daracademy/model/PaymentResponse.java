package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponse {

    private String paymentId;

    private String clientId;

    private String postId;

    private Integer amount;

    //private Date paymentDate;

}
