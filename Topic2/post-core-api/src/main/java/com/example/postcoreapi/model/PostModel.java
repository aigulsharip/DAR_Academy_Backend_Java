package com.example.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {

    @NotNull
    @Size(min = 2, max = 16, message = "PostId must be greater than 2 and less than 16")
    private String postId;

    @NotNull
    private String clientId;

    @NotNull
    private String postRecipientId;

    private String postItem;

    private String status;

    @Email
    private String email;



}
