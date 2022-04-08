package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    public static final HashMap<String, PostModel> postsMap = new HashMap<>();

    static {
        PostModel post1 = new PostModel(UUID.randomUUID().toString(), "ee736e63-8d12-437b-9599-b6bd05cfe05a", "7193f9df-18ad-48e2-91bf-5c177ef8607a", "letter or postcard", "processing", "email2@gmail.com");
        PostModel post2 = new PostModel(UUID.randomUUID().toString(), "ee736e63-8d12-437b-9599-b6bd05cfe05a", "2a17121e-1a01-4bdf-8a58-bb5f19f65e4e", "parcel", "shipped", "email1@gmail.com");
        PostModel post3 = new PostModel(UUID.randomUUID().toString(), "2a17121e-1a01-4bdf-8a58-bb5f19f65e4e","7193f9df-18ad-48e2-91bf-5c177ef8607a", "large envelope", "in transit", "email2@gmail.com");
        PostModel post4 = new PostModel(UUID.randomUUID().toString(), "8bc04d5e-831c-4760-a871-95006c9dd5d7", "2a17121e-1a01-4bdf-8a58-bb5f19f65e4e", "packets", "delivered", "email4@gmail.com");

        postsMap.put(post1.getPostId(), post1);
        postsMap.put(post2.getPostId(), post2);
        postsMap.put(post3.getPostId(), post3);
        postsMap.put(post4.getPostId(), post4);

    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postModel.setClientId(UUID.randomUUID().toString());
        postModel.setReceiverId(UUID.randomUUID().toString());
        postsMap.put(postModel.getPostId(), postModel);

    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postsMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postsMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postsMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
        postsMap.remove(postId);
    }
}
