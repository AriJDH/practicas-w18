package com.socialmeli2.be_java_hisp_w18g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode

public class NewPostDTORequest {

    @NotNull(message = "User id can not be empty")
    @Min(value = 1, message = "User id must be greater than zero")
    private Integer user_id;

    @NotNull(message = "Date field can not be empty") //
    private String date;

    @Valid
    private ProductDTORequest product;

    @NotNull(message = "Category field can not be empty")
    private Integer category;

    @NotNull(message = "Price field can not be empty")
    @DecimalMax(value = "10000000.0", message = "Price value must be less than 10.000.000")
    private Double price;
}
