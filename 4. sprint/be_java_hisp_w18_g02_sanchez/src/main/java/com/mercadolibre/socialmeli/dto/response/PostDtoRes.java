package com.mercadolibre.socialmeli.dto.response;

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
public class PostDtoRes {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
