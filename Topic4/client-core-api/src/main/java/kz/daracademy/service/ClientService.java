package kz.daracademy.service;

import kz.daracademy.model.ClientRequest;
import kz.daracademy.model.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse createClient(ClientRequest clientRequest);

    ClientResponse updateClient(ClientRequest clientRequest);

    ClientResponse getClientById(String clientId);

    List<ClientResponse> getAllClients();

    void deleteClientById(String clientId);


}
