package com.mercadolibre.practica.HQL.con.movies.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAat;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    private String name;
    private Integer ranking;
    private int active;

}
