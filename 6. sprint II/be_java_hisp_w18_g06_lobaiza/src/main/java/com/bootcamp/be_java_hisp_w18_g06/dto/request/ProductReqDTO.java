package com.bootcamp.be_java_hisp_w18_g06.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class ProductReqDTO {
    @NotNull(message = "Id cannot be empty")
    @Min(value = 1, message = "Id must be greater than 0")
    private Integer product_id;
    @NotBlank(message = "Product name field cannot be empty")
    @Size(max = 40, message = "Length cannot be greater than 40")
    @Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Product name cannot contain special characters(%, &, $, etc)")
    private String product_name;
    @NotBlank(message = "Type field cannot be empty")
    @Size(max = 15, message = "Length cannot be greater than 15")
    @Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Type cannot contain special characters(%, &, $, etc)")
    private String type;
    @NotBlank(message = "Brand Field cannot be empty")
    @Size(max = 15, message = "Length cannot be greater than 15")
    @Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Brand cannot contain special characters(%, &, $, etc)")
    private String brand;
    @NotBlank(message = "Color Field cannot be empty")
    @Size(max = 15, message = "Length cannot be greater than 15")
    @Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Color cannot contain special characters(%, &, $, etc)")
    private String color;
    @Size(max = 80, message = "Length cannot be greater than 80")
    @Pattern(regexp = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", message = "Notes cannot contain special characters(%, &, $, etc)")
    private String notes;
}
