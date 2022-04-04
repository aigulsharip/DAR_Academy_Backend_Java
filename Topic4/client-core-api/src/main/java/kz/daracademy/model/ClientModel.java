package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    @NotNull(message = "ClientId must not be null")
    @Size(min = 2, max = 16, message = "ClientId must be greater than 2 and less than 16")
    private String clientId;

    public String name;

    public String surname;

    @Email
    public String email;

}
