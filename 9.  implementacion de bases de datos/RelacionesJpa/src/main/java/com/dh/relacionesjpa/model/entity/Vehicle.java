package com.dh.relacionesjpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String plateNumber;
    private String brand;
    private String model;
    private Integer yearOfManufacture;
    private Integer wheels;


}
