package com.socialmedia.be_java_hisp_w18_Otero.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer post_id;
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private boolean has_promo = false;
    private double discount = 0;
    private Integer likes = 0;

    public Post(Integer postId, Integer user_id, LocalDate date, Product product, Integer category, Double price) {
        this.post_id = postId;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(Integer postId, Integer user_id, LocalDate date, Product product, int category, double price, boolean b,
                double discount) {
        super();
        this.has_promo = b;
        this.discount= discount;
    }

    public void addLike(){
        likes++;
    }
}
