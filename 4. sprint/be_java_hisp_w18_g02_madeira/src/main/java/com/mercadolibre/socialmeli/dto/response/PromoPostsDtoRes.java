package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli.dto.PromoPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PromoPostsDtoRes {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String name;
    List<PromoPostDto> posts;
}
