package com.vroom.autos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String make;
    private String model;
    private Integer fabricationYear;
    private Integer wheelCount;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Accident> accidentList;
}
