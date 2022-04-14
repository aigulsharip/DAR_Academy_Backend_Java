package kz.daracademy.service;

import kz.daracademy.model.ClientRequest;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.repository.ClientEntity;
import kz.daracademy.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        ClientEntity dbclient = clientRepository.getClientEntityByClientId(clientRequest.getClientId());
        clientEntity.setId(dbclient.getId());
        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);

    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.getClientEntityByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);

    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.getClientEntitiesBy().stream().map(client -> modelMapper.map(client, ClientResponse.class)).collect(Collectors.toList());

    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntityByClientId(clientId);
    }
}
