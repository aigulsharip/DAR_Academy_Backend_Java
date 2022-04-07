package kz.daracademy.service;

import kz.daracademy.dto.ClientDTO;
import kz.daracademy.dto.PostDTO;
import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import kz.daracademy.mapper.PostMapper;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private final PostFeign postFeign;
    private final ClientFeign clientFeign;

    public List<PostModel> getAllPostsList() {return  postFeign.getAllPosts(); }

    public List<PostDTO> getAllPostsListDTO(){
        return postMapper.postsListToDto(getAllPostsList());
    }

    public ClientDTO getClientById(String clientId) {
        return clientFeign.getClientByIdClient(clientId);
    }




}
