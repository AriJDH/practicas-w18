package com.mercadolibre.socialmeli2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class UserDtoRes {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
}
