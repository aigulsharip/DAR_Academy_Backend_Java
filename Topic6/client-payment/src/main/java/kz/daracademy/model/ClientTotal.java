package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientTotal {
    public String clientId;

    public ClientResponse client;

    public Integer totalPaymentsAmount;

    public Integer numberOfPayments;

}
