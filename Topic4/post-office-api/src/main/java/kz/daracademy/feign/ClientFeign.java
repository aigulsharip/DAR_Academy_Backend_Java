package kz.daracademy.feign;

import kz.daracademy.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClientApi();

    @GetMapping("/client/all")
    List<ClientResponse> getAllClients();


    @GetMapping("/client/{clientId}")
    ClientResponse getClientById(@PathVariable String clientId);



}
