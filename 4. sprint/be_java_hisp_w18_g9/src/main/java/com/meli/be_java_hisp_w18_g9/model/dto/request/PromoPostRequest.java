package com.meli.be_java_hisp_w18_g9.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostRequest {

    // ? =============== Attributes =============== ?

    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Product product;

    private Integer category;

    private Double price;

    @JsonProperty("has_promo")
    private Boolean hasPromo;

    private Double discount;

}
