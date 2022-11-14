package com.waow.calories.repository;

import com.waow.calories.entity.Plate;

import java.util.Optional;

public interface IPlateRepository {
    Optional<Plate> findPlateByName(String name);
}
