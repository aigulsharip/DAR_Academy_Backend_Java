package com.example.postcoreapi.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "posts_table")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    String postId;

    String clientId;

    String receiverId;

    String postItem;

    String status;
}
