package com.example.postcoreapi.service.post;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.repository.PostEntity;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest) {
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        PostEntity dbEntity = postRepository.getPostEntityByPostId(postRequest.getPostId());
        postEntity.setId(dbEntity.getId());
        postEntity = postRepository.save(postEntity);
        return modelMapper.map(postEntity, PostResponse.class);


    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.getPostEntitiesBy().stream().map(post -> modelMapper.map(post, PostResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {
        PostEntity postEntity = postRepository.getPostEntityByPostId(postId);
        return modelMapper.map(postEntity, PostResponse.class);


    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostEntityByPostId(postId);
    }
}
