package com.mercadolibre.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerFollowerCountDtoRes {
    private Integer id;
    private String name;
    private Integer followersCount;

}
