package com.example.postcoreapi.service.post;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostRequest postRequest);


    PostResponse updatePost(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postId);

    void deletePostById(String postId);
}
