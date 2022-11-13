package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Persona {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private String sintomas;

}
