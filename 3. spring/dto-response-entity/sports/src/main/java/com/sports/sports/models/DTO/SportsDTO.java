package com.sports.sports.models.DTO;

import com.sports.sports.models.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SportsDTO {
    String name;
    Level lvl;
    String message;
}
