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
        PostModel post1 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "letter or postcard", "processing", "email2@gmail.com");
        PostModel post2 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "parcel", "shipped", "email1@gmail.com");
        PostModel post3 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "large envelope", "in transit", "email2@gmail.com");
        PostModel post4 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "packets", "delivered", "email4@gmail.com");

        postsMap.put(post1.getPostId(), post1);
        postsMap.put(post2.getPostId(), post2);
        postsMap.put(post3.getPostId(), post3);
        postsMap.put(post4.getPostId(), post4);

    }


    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postModel.setClientId(UUID.randomUUID().toString());
        postModel.setPostRecipientId(UUID.randomUUID().toString());
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
        //postModel.setPostId(UUID.randomUUID().toString());
        postsMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
        postsMap.remove(postId);
    }

    /*
    3.3 Реализовать RESTful методы для проекта post-core-api сервиса PostService и его имплементации PostServiceImpl:
        Метод createPost() для создания заказа посылки
        Метод getAllPosts() для вывода списка посылок
        Метод getPostById() для вывода данных о посылке по ID
        Метод updatePostById() для обновления данных о посылке по ID
        Метод deletePostById() для удаления данных о посылке по ID
     */
}
