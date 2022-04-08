package kz.daracademy.dto;

import kz.daracademy.model.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String postId;
    private String clientId;
    private ClientResponse client;
    //private String receiverId;
    //private ClientResponse receiver;
    private String postItem;
    private String status;






}
