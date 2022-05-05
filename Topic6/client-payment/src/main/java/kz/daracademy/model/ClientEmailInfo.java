package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientEmailInfo {

    private String totalPaymentId;

    private String clientName;

    private String clientEmail;

    public Integer totalPaymentsAmount;




}
