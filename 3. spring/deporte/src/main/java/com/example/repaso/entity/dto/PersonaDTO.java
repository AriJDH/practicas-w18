package com.example.repaso.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonaDTO {

    private String name;
    private String lastName;
    private ArrayList<DeporteDTO> deportesFrecuentes;
}
