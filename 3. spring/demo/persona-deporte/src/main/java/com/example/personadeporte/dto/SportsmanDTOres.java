package com.example.personadeporte.dto;

import com.example.personadeporte.entity.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportsmanDTOres {
    private String name;
    private List<String> sports;
}
