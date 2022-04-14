package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostRequest;
import com.example.postcoreapi.model.PostResponse;
import com.example.postcoreapi.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public String check() {
        return "post-core-api is working at the port";
    }

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    @PutMapping
    public PostResponse updatePost(@RequestBody PostRequest postRequest, @RequestParam String postId) {
        postRequest.setPostId(postId);
        return postService.updatePost(postRequest);
    }
    @GetMapping("/all")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping()
    public PostResponse getAllPostById(@RequestParam String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping
    public void deletePost(@RequestParam String postId) {
        postService.deletePostById(postId);
    }

}
