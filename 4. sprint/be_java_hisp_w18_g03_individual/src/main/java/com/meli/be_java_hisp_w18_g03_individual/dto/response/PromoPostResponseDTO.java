package com.meli.be_java_hisp_w18_g03_individual.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostResponseDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("product")
    private ProductResponseDTO product;
    @JsonProperty("category")
    private Integer category;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("hasPromo")
    private Boolean hasPromo;
    @JsonProperty("discount")
    private Double discount;
}
