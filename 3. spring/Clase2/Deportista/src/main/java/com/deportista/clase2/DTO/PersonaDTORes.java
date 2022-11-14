package com.deportista.clase2.DTO;

import com.deportista.clase2.entity.Deporte;
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
    private ArrayList<Deporte> deportesFrecuentes;

}