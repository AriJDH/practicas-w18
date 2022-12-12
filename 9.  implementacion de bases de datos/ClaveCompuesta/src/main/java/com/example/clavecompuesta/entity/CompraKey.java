package com.example.clavecompuesta.entity;

import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CompraKey implements Serializable {
    private Integer clienteid;
    private LocalDate fecha;
}
