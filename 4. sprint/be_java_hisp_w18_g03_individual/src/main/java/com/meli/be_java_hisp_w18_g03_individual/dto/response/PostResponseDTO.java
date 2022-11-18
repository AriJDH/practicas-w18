package com.meli.be_java_hisp_w18_g03_individual.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponseDTO {
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private ProductResponseDTO product;
    private Integer category;
    private Double price;
    @JsonProperty("post_id")
    private Integer postId;
}
