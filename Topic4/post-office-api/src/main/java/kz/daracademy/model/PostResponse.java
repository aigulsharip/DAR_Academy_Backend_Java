package kz.daracademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {

    private String postId;
    private ClientResponse client;
    private ClientResponse receiver;
    private String postItem;
    private String status;
}
