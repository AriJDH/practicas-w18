package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerFollowerListDtoRes {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    private List<UserDtoRes> followers;
}
