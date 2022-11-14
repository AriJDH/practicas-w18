package com.example.concesionarioautos.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private LocalDate date;
    private Double kilometers;
    private String descriptions;

}
