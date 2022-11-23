package com.jcundere.ejerciciopractico05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<SintomaEntity> sintomaAsociadoList = new ArrayList<>();


    public PersonaEntity(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }


    public void addSintomaEntity(SintomaEntity sintomaEntity) {
        sintomaAsociadoList.add(sintomaEntity);
    }

}
