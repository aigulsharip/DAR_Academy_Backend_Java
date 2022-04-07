package kz.daracademy.feign;

import kz.daracademy.dto.ClientDTO;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClientApi();

    @GetMapping("/client/all")
    //List<ClientResponse> getAllClients();
    String getAllClients();


    @GetMapping("/client/{clientId}")
    String getClientById(@PathVariable String clientId);

    @GetMapping("/client/{clientId}")
    ClientDTO getClientByIdClient(@PathVariable String clientId);








}
