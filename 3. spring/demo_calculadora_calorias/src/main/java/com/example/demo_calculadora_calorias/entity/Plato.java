package com.example.demo_calculadora_calorias.entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String name;
    private Integer calories;
}
