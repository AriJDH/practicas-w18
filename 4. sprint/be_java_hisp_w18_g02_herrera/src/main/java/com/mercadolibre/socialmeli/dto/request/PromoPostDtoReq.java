package com.mercadolibre.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostDtoReq {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private Double discount;

    public PromoPostDtoReq(PostDtoReq postDtoReq) {
        this.userId = postDtoReq.getUserId();
        this.date = postDtoReq.getDate();
        this.product = postDtoReq.getProduct();
        this.category = postDtoReq.getCategory();
        this.price = postDtoReq.getPrice();
        this.hasPromo = false;
        this.discount = Double.valueOf(0);
    }
}