package kz.daracademy.controller;

import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {

    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;


    @GetMapping("/check")
    public String checkPostOffice() {
        return "post-office-api is working";
    }

    @GetMapping("/post/check")
    public String checkPost() {
        return postFeign.checkPostApi();
    }
    @GetMapping("/client/check")
    public String checkClient() {return clientFeign.checkClientApi();}

    @GetMapping("/post/all")
    public List<PostResponse> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostResponse getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public PostResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }











}
