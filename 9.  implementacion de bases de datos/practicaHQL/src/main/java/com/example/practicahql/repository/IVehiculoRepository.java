package com.example.practicahql.repository;

import com.example.practicahql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("SELECT v.patente FROM Vehiculo v ")
    List<String> findPatentes();

    @Query("SELECT v.patente as patente, v.marca as marca FROM Vehiculo v order by v.anioFabricacion")
    List<String> findPatentesMarca();

}
