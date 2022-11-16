package com.example.calculadora.repository;

import com.example.calculadora.entity.Plate;

import java.util.List;

public interface IPlateRepository {

    void create();
    List<Plate> findAll();
}
