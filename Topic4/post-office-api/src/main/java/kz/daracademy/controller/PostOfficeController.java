package kz.daracademy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import kz.daracademy.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<PostModel> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }

    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() throws JsonProcessingException {
        //return clientFeign.getAllClients();
        String jsonClients= clientFeign.getAllClients();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<ClientResponse> clients = objectMapper.readValue(jsonClients, new TypeReference<List<ClientResponse>>(){});
        return clients;

    }


    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) throws JsonProcessingException {
        String json = clientFeign.getClientById(clientId);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ClientResponse client = objectMapper.readValue(json, ClientResponse.class);
        return client;

    }











}
