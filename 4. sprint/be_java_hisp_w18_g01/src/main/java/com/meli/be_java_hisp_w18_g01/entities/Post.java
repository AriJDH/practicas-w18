package com.meli.be_java_hisp_w18_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long post_id;
    private User user;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean has_promo;

    private double discount;

    public Post(long post_id, User user, LocalDate date, Product product, int category, double price) {
        this.post_id = post_id;
        this.user = user;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public boolean isRecent(){
        long weeksBetween = ChronoUnit.WEEKS.between(date, LocalDate.now());
       return weeksBetween>=0 && weeksBetween<3;
    }

    public boolean isPromotion(){
        return this.has_promo;
    }


}
