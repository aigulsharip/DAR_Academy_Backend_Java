package kz.daracademy.feign;

import kz.daracademy.model.PostModel;
import kz.daracademy.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "post-core-api")
public interface PostFeign {

    @GetMapping("/post/check")
    String checkPostApi();


    @GetMapping("/post/all")
    List<PostModel> getAllPosts();

    @GetMapping("/post/{postId}")
    PostModel getPostById(@PathVariable String postId);




}
