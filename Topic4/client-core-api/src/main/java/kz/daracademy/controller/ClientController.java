package kz.daracademy.controller;

import kz.daracademy.model.ClientModel;
import kz.daracademy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping()
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<String>("New Client successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientbyId (@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClient (@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Client successfully updated", HttpStatus.OK);

    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable String clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Client succesfully deleted", HttpStatus.OK);
    }



}
