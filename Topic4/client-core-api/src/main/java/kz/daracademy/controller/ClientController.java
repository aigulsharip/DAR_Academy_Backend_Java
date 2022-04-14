package kz.daracademy.controller;

import kz.daracademy.model.ClientRequest;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;


    @GetMapping("/check")
    public String check() {
        return "client-core-api is working";
    }

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientRequest clientRequest) {
        return clientService.createClient(clientRequest);
        //return new ResponseEntity<String>("New Client successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping
    public ClientResponse getClientById (@RequestParam String clientId) {
        return clientService.getClientById(clientId);
    }


    @PutMapping
    public ClientResponse updateClientById(@RequestParam String clientId, @RequestBody ClientRequest clientRequest) {
        clientRequest.setClientId(clientId);
        return clientService.updateClient(clientRequest);
        //return new ResponseEntity<String>("Client successfully updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientById(@RequestParam String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Client succesfully deleted", HttpStatus.OK);

    }

}
