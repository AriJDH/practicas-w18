package com.mercadolibre.socialmeli2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDtoReq {
    @JsonProperty("user_id")
    @NotNull(message= Constants.USER_ID_REQUIRED)
    @Positive(message= Constants.USER_ID_POSITIVE)
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message=Constants.DATE_REQUIRED)
    private LocalDate date;
    @Valid
    private ProductDto product;
    @NotNull(message = Constants.CATEGORY_REQUIRED)
    private Integer category;
    @NotNull(message=Constants.PRICE_REQUIRED)
    @Positive(message = Constants.MIN_PRICE)
    @Max(value=10000000, message= Constants.MAX_PRICE)
    private Double price;

}
