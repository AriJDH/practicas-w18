package com.example.pr_grupal_dto_deportes.DTO;

import com.example.pr_grupal_dto_deportes.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDTORes {
    private String name;
    private String lastName;
    private ArrayList<DeporteDTORes> deportesFrecuentes;

}