package com.mercadolibre.socialmeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli2.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {
    @JsonProperty("product_id")
    @NotNull(message = Constants.PRODUCT_ID_REQUIRED)
    @Positive(message = Constants.PRODUCT_ID_POSITIVE)
    private Integer id;
    @JsonProperty("product_name")
    @NotBlank(message= Constants.PRODUCT_NAME_REQUIRED)
    @Size(max=40, message = Constants.PRODUCT_NAME_MAX_LENGTH_40)
    @Pattern(regexp = "[\\w|\\s]*", message = Constants.PRODUCT_NAME_SPECIAL_CHARACTERS_NOT_ALLOWED)
    private String name;
    @NotBlank(message = Constants.TYPE_REQUIRED)
    @Size(max=15, message = Constants.TYPE_MAX_LENGTH_15)
    @Pattern(regexp = "[\\w]*", message = Constants.TYPE_SPECIAL_CHARACTERS_NOT_ALLOWED)
    private String type;
    @NotBlank(message = Constants.BRAND_REQUIRED)
    @Size(max=15, message = Constants.BRAND_MAX_LENGTH_15)
    @Pattern(regexp = "[\\w|\\s]*", message = Constants.BRAND_SPECIAL_CHARACTERS_NOT_ALLOWED)
    private String brand;
    @NotBlank(message = Constants.COLOR_REQUIRED)
    @Size(max=15, message = Constants.COLOR_MAX_LENGTH_15)
    @Pattern(regexp = "[\\w]*", message = Constants.COLOR_SPECIAL_CHARACTERS_NOT_ALLOWED)
    private String color;
    @Size(max=80, message = Constants.MAX_LENGTH_80)
    @Pattern(regexp = "[\\w|\\s]*", message = Constants.NOTES_SPECIAL_CHARACTERS_NOT_ALLOWED)
    private String notes;
}
