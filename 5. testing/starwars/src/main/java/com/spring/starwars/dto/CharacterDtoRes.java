package com.spring.starwars.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CharacterDtoRes {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
