package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDtoRes {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
}
