package kz.daracademy.service;

import kz.daracademy.dto.PostDTO;
import kz.daracademy.model.PostResponse;
import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import kz.daracademy.mapper.ClientMapper;
import kz.daracademy.mapper.PostMapper;
import kz.daracademy.model.PostModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;
    private  final ClientMapper clientMapper;
    private final PostFeign postFeign;
    private final ClientFeign clientFeign;

    public List<PostModel> getAllPostsList() {return  postFeign.getAllPosts(); }

    public List<PostDTO> getAllPostsListDTO(){
        return postMapper.postsListToDto(getAllPostsList());
    }






}
