package com.jcundere.ejerciciopractico07c.repository;

import com.jcundere.ejerciciopractico07c.entity.VehicleEntity;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {

    VehicleEntity saveEntity(VehicleEntity vehicleEntity);

    Optional<VehicleEntity> getEntityById(Integer id);

    List<VehicleEntity> getAllEntity();

}
