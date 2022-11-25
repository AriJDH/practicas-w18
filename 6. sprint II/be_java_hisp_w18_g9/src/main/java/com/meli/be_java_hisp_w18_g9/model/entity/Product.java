package com.meli.be_java_hisp_w18_g9.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    // ? =============== Attributes =============== ?

    @JsonProperty("product_id")
    @NotNull(message = "The product id field cannot be empty")
    @Positive(message = "The product id field must be greater than zero")
    private Integer productId;

    @JsonProperty("product_name")
    @NotNull(message = "The product name field cannot be null")
    @NotBlank(message = "Product name is required")
    @Max(value = 40, message = "The product name must have a maximum of 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The product name must not contain special characters, only letters, numbers and spaces")
    private String productName;

    @NotNull(message = "The product type field cannot be null")
    @NotEmpty(message = "The product type field cannot be empty")
    @Max(value = 15, message = "The product type must have a maximum of 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "The product name must not contain special characters, only letters and numbers")
    private String type;

    @NotBlank(message = "Product brand is required")
    @Max(value = 25, message = "The product brand must have a maximum of 25 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "The product name must not contain special characters, only letters and numbers")
    private String brand;

    @NotNull(message = "The product color field cannot be null")
    @NotBlank(message = "Product color is required")
    @Max(value = 15, message = "The product color must have a maximum of 15 characters")
    private String color;

    @Max(value = 80, message = "The product notes must have a maximum of 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The product name must not contain special characters, only letters, numbers and spaces")
    private String notes;

}
