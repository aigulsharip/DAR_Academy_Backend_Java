package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ClientEmailInfo {

    private String totalPaymentId;

    private String clientName;

    private String clientEmail;

    private HashMap<String, Integer> clientPayments;

    public Integer totalPaymentsAmount;




}
