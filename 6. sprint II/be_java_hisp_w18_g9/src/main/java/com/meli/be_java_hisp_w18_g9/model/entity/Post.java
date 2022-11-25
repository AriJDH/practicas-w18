package com.meli.be_java_hisp_w18_g9.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    // ? =============== Attributes =============== ?

    @JsonProperty("post_id")
    private Integer postId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Product product;

    @NotNull(message = "The post_id field cannot be empty")
    private Integer category;
    private Double price;

    @JsonProperty("has_promo")
    private Boolean hasPromo;

    private Double discount;

}
