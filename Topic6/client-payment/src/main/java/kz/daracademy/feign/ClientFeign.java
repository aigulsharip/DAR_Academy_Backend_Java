package kz.daracademy.feign;

import kz.daracademy.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/")
    ClientResponse getClientById (@RequestParam String clientId);


}




