package com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PostDtoRequest {

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

}
