package kz.daracademy.service;

import kz.daracademy.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    public static final HashMap<String, ClientModel> clientMap = new HashMap<>();


    static {
        ClientModel client1 = new ClientModel(UUID.randomUUID().toString(), "Mary", "Smith", "marysmith@gmail.com");
        ClientModel client2 = new ClientModel(UUID.randomUUID().toString(), "Anny", "Block", "annyblock@gmail.com");
        ClientModel client3 = new ClientModel(UUID.randomUUID().toString(), "Bruno", "Mars", "brunomars@gmail.com");
        ClientModel client4 = new ClientModel(UUID.randomUUID().toString(), "Michael", "Thomson", "michaelthomson@gmail.com");

        clientMap.put(client1.getClientId(), client1);
        clientMap.put(client2.getClientId(), client2);
        clientMap.put(client3.getClientId(), client3);
        clientMap.put(client4.getClientId(), client4);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);

    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientMap.put(clientId, clientModel);

    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);

    }
}
