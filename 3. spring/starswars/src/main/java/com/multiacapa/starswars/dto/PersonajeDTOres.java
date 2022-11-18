package com.multiacapa.starswars.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PersonajeDTOres {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeWorld;
    private String species;

}
