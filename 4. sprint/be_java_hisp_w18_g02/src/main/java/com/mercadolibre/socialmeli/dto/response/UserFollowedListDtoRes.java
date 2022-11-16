package com.mercadolibre.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowedListDtoRes {
    private Integer id;
    private String name;
    private List<UserDtoRes> followed;
}