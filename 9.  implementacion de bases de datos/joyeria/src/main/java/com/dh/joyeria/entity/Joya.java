package com.dh.joyeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Joya joya = (Joya) o;
        return id != null && Objects.equals(id, joya.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
