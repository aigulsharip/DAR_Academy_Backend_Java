package kz.daracademy.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.daracademy.dto.PostDTO;
import kz.daracademy.model.PostResponse;
import kz.daracademy.feign.ClientFeign;
import kz.daracademy.model.ClientModel;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PostMapper {
    @Autowired
    ClientFeign clientFeign;

    PostDTO postToDTO(PostModel postModel) throws JsonProcessingException {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postModel.getPostId());
        postDTO.setStatus(postModel.getStatus());
        postDTO.setPostItem(postModel.getPostItem());
        postDTO.setClientId(postModel.getClientId());
        String clientId = postModel.getClientId();


        ClientResponse clientResponse = clientFeign.getClientById(clientId);
        postDTO.setClient(clientResponse);



        /*
        String json = clientFeign.getClientByIdString(clientId);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ClientResponse clientResponse = objectMapper.readValue(json, ClientResponse.class);
        postDTO.setClient(clientResponse);
         */



        return postDTO;

    }

    public abstract ClientResponse clientToDTO(ClientModel clientModel);

    //public abstract List<PostResponse> postsListToDto(List<PostModel> posts);

    public abstract List<PostDTO> postsListToDto(Collection<PostModel> posts);





}
