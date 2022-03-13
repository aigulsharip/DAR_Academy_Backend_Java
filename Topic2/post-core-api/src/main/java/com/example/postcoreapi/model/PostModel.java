package com.example.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostModel {

    @NotNull
    private String postId;

    @NotNull
    private String clientId;

    @NotNull
    private String postRecipientId;

    private String postItem;

    private String status;



}
