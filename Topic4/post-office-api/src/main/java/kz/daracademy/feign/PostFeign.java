package kz.daracademy.feign;

import kz.daracademy.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post-core-api")
public interface PostFeign {

    @GetMapping("/post/check")
    String checkPostApi();


    @GetMapping("/post/all")
    List<PostResponse> getAllPosts();

    @GetMapping("/post/{postId}")
    PostResponse getPostById(String postId);


}
