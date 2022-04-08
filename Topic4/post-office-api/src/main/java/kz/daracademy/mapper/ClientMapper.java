package kz.daracademy.mapper;

import kz.daracademy.model.ClientModel;
import kz.daracademy.model.ClientResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ClientMapper {

    ClientResponse clientToResponse(ClientModel clientModel);
    List<ClientResponse> clientListToResponse(List<ClientModel> posts);
}
