package com.example.starwars.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CharacterDTO {
    String name;
    String height, mass;
    String hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
}
