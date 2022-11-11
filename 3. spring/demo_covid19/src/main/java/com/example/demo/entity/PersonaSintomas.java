package com.example.demo.entity;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaSintomas {
    private Persona persona;
    private List<Sintoma> sintomaList;
}
