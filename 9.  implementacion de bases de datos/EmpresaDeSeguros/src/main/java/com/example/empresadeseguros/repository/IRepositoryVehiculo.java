package com.example.empresadeseguros.repository;

import com.example.empresadeseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryVehiculo extends JpaRepository<Vehiculo, Integer> {
    @Query("From Vehiculo")
    List<Vehiculo> findAllVehiculos();

    @Query("From Vehiculo order by anio asc")
    List<Vehiculo> findAllVehiculosOrderbyAnio();
}
