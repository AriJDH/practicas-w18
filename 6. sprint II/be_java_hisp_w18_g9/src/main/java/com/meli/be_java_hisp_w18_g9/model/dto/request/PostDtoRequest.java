package com.meli.be_java_hisp_w18_g9.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PostDtoRequest {

    // ? =============== Attributes =============== ?

    @JsonProperty("post_id")
    @NotNull(message = "The post_id field cannot be empty")
    @Positive(message = "The post_id must be greater than zero")
    private Integer postId;

    @JsonProperty("user_id")
    @NotNull(message = "The user_id field cannot be null")
    @Positive(message = "The user_id field must be greater than zero")
    private Integer userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "The date field cannot be empty")
    private LocalDate date;

    @Valid
    @NotNull(message = "The product field cannot be empty")
    private Product product;

    @NotNull(message = "The category field cannot be empty")
    private Integer category;

    @NotNull(message = "The price field cannot be empty")
    @PositiveOrZero(message = "The price field cannot be negative")
    @DecimalMax(value = "10000000", message = "The price field cannot be greater than 10.000.000")
    private Double price;

}
