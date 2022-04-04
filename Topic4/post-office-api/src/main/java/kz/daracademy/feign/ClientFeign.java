package kz.daracademy.feign;

import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClientApi();


    @GetMapping("/client/all")
    List<ClientResponse> getAllClients();

    @GetMapping("/client/{clientId}")
    PostResponse getClientById(String clientId);





}
