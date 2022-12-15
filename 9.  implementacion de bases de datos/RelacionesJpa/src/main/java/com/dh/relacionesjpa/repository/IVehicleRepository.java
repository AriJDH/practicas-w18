package com.dh.relacionesjpa.repository;

import com.dh.relacionesjpa.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {


}
