package kz.daracademy.mapper;

import kz.daracademy.dto.ClientDTO;
import kz.daracademy.model.PostResponse;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapperOld {

    PostResponse postToDTO(PostResponse postResponse);

    ClientDTO clientToDTO(ClientResponse clientResponse);

    List<PostResponse> postsListToDto(List<PostModel> posts);

    //ItemDTO itemToDto(Item item);
    //CountryDTO countryToDTO (Country country);


}
