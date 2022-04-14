package com.example.postcoreapi.controller.deprecated;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.deprecated.PostServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deprecated/post")
public class PostControllerOld {

    @Autowired
    PostServiceOld postServiceOld;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String initialChecking() {
        return "post-core-api is working at the port " + env.getProperty("local.server.port");
    }

    @PostMapping()
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel) {
        postServiceOld.createPost(postModel);
        return new ResponseEntity<String>("Post successfully created", HttpStatus.OK);

    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postServiceOld.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postServiceOld.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        postServiceOld.updatePostById(postId, postModel);
        return new ResponseEntity<String>("Post successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable String postId) {
        postServiceOld.deletePostById(postId);
        return new ResponseEntity<String>("Post succesfully deleted", HttpStatus.OK);
    }

}
