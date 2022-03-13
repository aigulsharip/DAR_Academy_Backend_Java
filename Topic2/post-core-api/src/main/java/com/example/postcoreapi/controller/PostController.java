package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public void initialChecking () {
        System.out.println("post-core-api is working");
    }

    @PostMapping()
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel) {
        postService.createPost(postModel);
        return new ResponseEntity<String>("Post successfully created", HttpStatus.OK);

    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("{postId}")
    public PostModel getPostStatusById (@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<String>("Post successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Post succesfully deleted", HttpStatus.OK);
    }

    /*
      Проверка работоспособности проекта (вывод строки "post-core-api is working") Метод GET /post/check
        Отправить посылку Метод POST /post
        Получить список всех посылок Метод GET /post/all
        Просмотреть статус посылки по ID Метод GET /post/{postId}
        Изменить данные о посылке по ID Метод PUT /post/{postId}
        Удалить данные о посылке по ID Метод DELETE /post/{userId}
     */

}
