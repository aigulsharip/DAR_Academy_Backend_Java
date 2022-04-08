package kz.daracademy.dto;

import kz.daracademy.model.ClientResponse;
import kz.daracademy.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class PostDTO {

    private String postId;
    private String postItem;
    private String status;
    private String clientId;
    private ClientResponse client;
    //private String receiverId;
    //private ClientDTO receiver;



    //private ClientDTO clientDTO = postService.getClientById(clientId);


}
