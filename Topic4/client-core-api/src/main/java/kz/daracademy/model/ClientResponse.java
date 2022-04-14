package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientResponse {

    private String clientId;

    public String name;

    public String surname;

    public String email;

}
