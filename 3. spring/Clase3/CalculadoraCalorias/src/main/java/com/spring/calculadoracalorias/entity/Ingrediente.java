package com.spring.calculadoracalorias.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Ingrediente {
    private String name;
    private Integer calories;
}
