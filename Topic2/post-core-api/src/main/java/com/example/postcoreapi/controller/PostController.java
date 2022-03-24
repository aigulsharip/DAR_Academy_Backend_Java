package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String initialChecking() {
        return "post-core-api is working at the port " + env.getProperty("local.server.port");
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

    @GetMapping("/{postId}")
    public PostModel getPostStatusById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<String>("Post successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("Post succesfully deleted", HttpStatus.OK);
    }

}
