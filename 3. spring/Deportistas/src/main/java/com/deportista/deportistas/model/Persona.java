package com.deportista.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    String nombre;
    String apellido;
    Integer edad;
    List<Deporte> deportes;
}
