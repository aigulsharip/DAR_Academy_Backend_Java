package kz.daracademy.model;

import kz.daracademy.model.ClientResponse;
import kz.daracademy.service.PostService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private String postId;
    private ClientResponse client;
    private ClientResponse receiver;
    private String postItem;
    private String status;






}
