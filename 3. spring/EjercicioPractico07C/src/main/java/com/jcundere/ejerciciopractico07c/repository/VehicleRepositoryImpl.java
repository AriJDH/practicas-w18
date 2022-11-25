package com.jcundere.ejerciciopractico07c.repository;

import com.jcundere.ejerciciopractico07c.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository {

    public static Integer idCounter = 0;
    List<VehicleEntity> vehicleEntityList = new ArrayList<>();


    @Override
    public VehicleEntity saveEntity(VehicleEntity vehicleEntity) {

        idCounter += 1;
        vehicleEntity.setId(idCounter);
        vehicleEntityList.add(vehicleEntity);

        return vehicleEntity;
    }

    @Override
    public Optional<VehicleEntity> getEntityById(Integer id) {

        for (VehicleEntity entity : vehicleEntityList) {

            if (entity.getId().equals(id)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<VehicleEntity> getAllEntity() {
        return this.vehicleEntityList;
    }

}
