package com.example.demo.entity;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonaDeporte {
    private Persona persona;
    private List<Deporte> deporteList;
}
