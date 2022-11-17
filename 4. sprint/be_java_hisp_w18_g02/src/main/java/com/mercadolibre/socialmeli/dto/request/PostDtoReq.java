package com.mercadolibre.socialmeli.dto.request;

import com.mercadolibre.socialmeli.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDtoReq {
    private Integer userId;
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;

}
