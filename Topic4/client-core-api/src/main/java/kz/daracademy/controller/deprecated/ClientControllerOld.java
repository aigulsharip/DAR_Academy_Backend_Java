package kz.daracademy.controller.deprecated;

import kz.daracademy.model.ClientModel;
import kz.daracademy.service.deprecated.ClientServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/client")
public class ClientControllerOld {

    @Autowired
    ClientServiceOld clientServiceOld;

    @GetMapping("/check")
    public String check() {
        return "client-core-api is working";
    }

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.createClient(clientModel);
        return new ResponseEntity<String>("New Client successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientServiceOld.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById (@PathVariable String clientId) {
        return clientServiceOld.getClientById(clientId);
    }


    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(@PathVariable String clientId, @Valid @RequestBody ClientModel clientModel) {
        clientServiceOld.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Client successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable String clientId) {
        clientServiceOld.deleteClientById(clientId);
        return new ResponseEntity<String>("Client succesfully deleted", HttpStatus.OK);

    }


}
