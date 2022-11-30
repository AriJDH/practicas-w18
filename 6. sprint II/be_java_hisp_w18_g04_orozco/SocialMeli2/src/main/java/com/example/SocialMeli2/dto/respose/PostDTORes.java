package com.example.SocialMeli2.dto.respose;

import com.example.SocialMeli2.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class PostDTORes {
    private Integer user_id;
    private Integer post_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTORes product;
    private Integer category;
    private Double price;

    public PostDTORes(Integer user_id, Post post) {
        this.user_id = user_id;
        this.post_id = post.getPost_id();
        this.date = post.getDate();
        this.product = new ProductDTORes(post.getProduct());
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
