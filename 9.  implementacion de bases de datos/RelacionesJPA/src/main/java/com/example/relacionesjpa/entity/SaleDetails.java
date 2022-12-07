package com.example.relacionesjpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
