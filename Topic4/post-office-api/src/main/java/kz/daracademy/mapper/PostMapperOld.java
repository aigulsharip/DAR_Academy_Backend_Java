package kz.daracademy.mapper;

import kz.daracademy.dto.ClientDTO;
import kz.daracademy.dto.PostDTO;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import kz.daracademy.model.PostResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapperOld {

    PostDTO postToDTO(PostResponse postResponse);

    ClientDTO clientToDTO(ClientResponse clientResponse);

    List<PostDTO> postsListToDto(List<PostModel> posts);

    //ItemDTO itemToDto(Item item);
    //CountryDTO countryToDTO (Country country);


}
