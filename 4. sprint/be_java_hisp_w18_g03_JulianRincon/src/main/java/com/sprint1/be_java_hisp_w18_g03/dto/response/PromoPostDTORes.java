package com.sprint1.be_java_hisp_w18_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoPostDTORes {
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private ProductResponseDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Float discount;
}
