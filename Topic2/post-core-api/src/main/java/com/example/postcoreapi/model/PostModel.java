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

    @NotNull(message = "PostId must not be null")
    @Size(min = 2, max = 16, message = "PostId must be greater than 2 and less than 16")
    String postId;

    @NotNull
    String clientId;

    @NotNull
    String receiverId;

    String postItem;

    String status;




}
