package com.example.SocialMeli2.dto.request;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ProductDTOReq {
    @NotNull(message = "The product id cannot be empty")
    @Positive(message = "The product id must be greater than 0")
    private Integer product_id;
    @NotEmpty(message = "The product name cannot be empty")
    @Size (min = 2,max = 40,message = "The length cannot exceed 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+(\\s+[a-zA-Z0-9]+)*$", message = "The field cannot have special characters")
    private String product_name;
    @NotEmpty(message = "The type cannot be empty")
    @Size (min = 2,max = 15,message = "The length cannot exceed 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+(\\s+[a-zA-Z0-9]+)*$", message = "The field cannot have special characters")
    private String type;
    @Size (min = 2,max = 25,message = "The length cannot exceed 25 characters")
    private String brand;
    @NotEmpty(message = "The type cannot be empty")
    @Size (min = 2,max = 15,message = "The length cannot exceed 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+(\\s+[a-zA-Z0-9]+)*$", message = "The field cannot have special characters")
    private String color;
    @Size (min = 2,max = 80,message = "The length cannot exceed 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+(\\s+[a-zA-Z0-9]+)*$", message = "The field cannot have special characters")
    private String notes;
}
