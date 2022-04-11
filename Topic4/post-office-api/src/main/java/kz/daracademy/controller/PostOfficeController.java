package kz.daracademy.controller;

import kz.daracademy.feign.ClientFeign;
import kz.daracademy.feign.PostFeign;
import kz.daracademy.model.ClientResponse;
import kz.daracademy.model.PostModel;
import kz.daracademy.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {

    @Autowired
    PostFeign postFeign;

    @Autowired
    ClientFeign clientFeign;


    @GetMapping("/check")
    public String check() {
        return "post-office-api is working ";
    }

    @GetMapping("/post/check")
    public String checkPost() {
        return postFeign.checkPostApi();
    }

    @GetMapping("/client/check")
    public String checkClient() {
        return clientFeign.checkClientApi();
    }


    @GetMapping("/post/all")
    public List<PostModel> getAllPosts() {
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postFeign.getPostById(postId);
    }


    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients() {
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientResponse getClientById(@PathVariable String clientId) {
        return clientFeign.getClientById(clientId);
    }


    @GetMapping("/post/details/{postId}")
    public PostResponse getPostDetails(@PathVariable String postId) {
        PostModel post = postFeign.getPostById(postId);
        System.out.println(post);
        String clientId = post.getClientId();
        System.out.println(clientId);
        ClientResponse client = clientFeign.getClientById(post.getClientId());
        ClientResponse receiver = clientFeign.getClientById(post.getReceiverId());

        System.out.println(client);

        return new PostResponse(postId, client, receiver, post.getPostItem(), post.getStatus());

       }
}
