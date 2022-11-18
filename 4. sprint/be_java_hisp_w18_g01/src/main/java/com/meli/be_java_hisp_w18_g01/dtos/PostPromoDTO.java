package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*Creo el DTO PostPromoDTO con su respectivo has_promo (Saber si tiene promoción)
 y discount (El descuento correspondiente) */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTO {
    private long user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
