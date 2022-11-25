package com.jcundere.ejerciciopractico07c.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {

    private LocalDate date;
    private Integer kilometers;
    private String descriptions;

}
