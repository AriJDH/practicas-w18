package com.hql.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Migrations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "migration", nullable = false, length = 255)
    private String migration;
    @Basic
    @Column(name = "batch", nullable = false)
    private int batch;

}
