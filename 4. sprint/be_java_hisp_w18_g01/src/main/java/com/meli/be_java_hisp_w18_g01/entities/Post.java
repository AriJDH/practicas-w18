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

    public Post(
            long post_id, User user, LocalDate date, Product product,
            int category, double price, boolean has_promo, double discount
    ) {
        this.post_id = post_id;
        this.user = user;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = setPriceWithDiscount(price, discount, has_promo);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public boolean isRecent(){
        long weeksBetween = ChronoUnit.WEEKS.between(date, LocalDate.now());
       return weeksBetween>=0 && weeksBetween<3;
    }

    public double setPriceWithDiscount(Double priceToDiscount, double discountToAply, boolean promo){
        System.out.println(promo);
        System.out.println(discountToAply);
        System.out.println(priceToDiscount);
        if(promo && discountToAply > 0 && discountToAply < 100 && promo) {
            priceToDiscount = priceToDiscount - ((priceToDiscount * discountToAply)/100);
            System.out.println("precio..:" + priceToDiscount);
        }
        System.out.println(priceToDiscount);
        return priceToDiscount;
    }
}
