package com.socialmeli2.be_java_hisp_w18g05.dto.request;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public class ProductDTORequest {

    @NotNull(message = "Product id can not be empty")
    @Min(value = 1, message = "Product id must be greater than zero")
    private Integer product_id;


    @Size(max = 40,message = "Product name can not have more than 40 figures")
    @NotBlank(message = "Product name can not be empty")
    @Pattern(regexp = "[^&%$#@!~]*", message = "Product name can not have special characters as ^&%$##@!~")
    private String product_name;

    @Size(max = 15,message = "Product type can not have more than 15 figures")
    @NotBlank(message = "Product type can not be empty")
    @Pattern(regexp = "[^&%$#@!~]*", message = "Product type can not have special characters as ^&%$##@!~")
    private String type;

    private String brand;

    @Size(max = 15,message = "Product color can not have more than 15 figures")
    @NotBlank(message = "Product color can not be empty")
    @Pattern(regexp = "[^&%$#@!~]*", message = "Product color can not have special characters as ^&%$##@!~")
    private String color;

    @Size(max = 80,message = "Product notes can not have more than 80 figures")
    @NotBlank(message = "Product notes can not be empty")
    @Pattern(regexp = "[^&%$#@!~]*", message = "Product notes can not have special characters as ^&%$##@!~")
    private String notes;
}
