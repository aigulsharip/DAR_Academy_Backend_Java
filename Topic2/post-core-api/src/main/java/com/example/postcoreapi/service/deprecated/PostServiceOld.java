package com.example.postcoreapi.service.deprecated;

import com.example.postcoreapi.model.PostModel;

import java.util.List;

public interface PostServiceOld {

    void createPost(PostModel postModel);

    List<PostModel> getAllPosts();

    PostModel getPostById(String postId);

    void updatePostById(String postId, PostModel postModel);

    void deletePostById(String postId);


}
