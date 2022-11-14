package com.example.concesionarioautos.repository;

import com.example.concesionarioautos.entity.Auto;

import java.util.Date;
import java.util.List;

public interface IAutoRepository {

    public void add(Auto auto);
    public List<Auto> listAll();
    public Auto findById(Long id);
    public List<Auto> findByYear(int desde, int hasta);
    public List<Auto> findeByPrice(Double desde, Double hasta);
}
