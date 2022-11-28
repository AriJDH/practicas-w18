package com.meli.be_java_hisp_w18_g01.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
public class Post {
    private long post_id;
    private User user;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;

    public Post(long post_id, User user, LocalDate date, Product product, int category, double price) {
        this.post_id = post_id;
        this.user = user;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public boolean isRecent(){
        long daysBetween = ChronoUnit.DAYS.between(date, LocalDate.now());
       return daysBetween>=0 && daysBetween<15;
    }
}
