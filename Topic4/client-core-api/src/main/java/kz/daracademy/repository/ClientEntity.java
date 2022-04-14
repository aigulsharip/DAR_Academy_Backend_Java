package kz.daracademy.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@Table(name = "clients_table")
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)

    private String clientId;

    public String name;

    public String surname;

    public String email;

}
