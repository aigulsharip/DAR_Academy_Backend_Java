package kz.daracademy.controller;

import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {

    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;


    @GetMapping("/check")
    public String check() {
        return "post-office-api is working";
    }

    @GetMapping("/post/check")
    public String checkPostFeignClient() {
        return postFeign.checkPostApi();
    }

    @GetMapping("/client/check")
    public String checkClientFeignClient() {return clientFeign.checkClientApi();}





}
