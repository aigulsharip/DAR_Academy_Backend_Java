package kz.daracademy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "client-core-api")
public interface ClientFeign {

    @GetMapping("/client/check")
    String checkClientApi();




}
