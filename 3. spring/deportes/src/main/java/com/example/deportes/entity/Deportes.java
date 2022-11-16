package com.example.deportes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Deportes {
    private int id;
    private String nombre;
    private String nivel;

    public int getId() {
        return id;
    }
}
