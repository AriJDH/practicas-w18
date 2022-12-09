package com.bootcamp.PracticaHQL.repository;

import com.bootcamp.PracticaHQL.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query("Select v.patente from Vehicle v")
    List<String> findAllByPatente();

    @Query("Select v.patente, v.marca from Vehicle v order by v.anioFabricacion")
    List<String[]> findAllByPatenteAndMarca();

    @Query("from Vehicle v where v.cantidadRuedas > 4")
    List<Vehicle> findAllPatenteByRuedas();

    @Query(value = "SELECT v.patente, v.marca, v.modelo FROM VEHICLE v join SINISTER s on v.id=s.vehicle_id where s.perdida_economica > 10000.00",nativeQuery = true)
    List<String[]> findByPatenteMarcaModeloBySinister();

    @Query(value = "SELECT v.patente, v.marca, v.modelo,s.perdida_economica FROM VEHICLE v join SINISTER s on v.id=s.vehicle_id where s.perdida_economica > 10000.00",nativeQuery = true)
    List<String[]> findByPatenteMarcaModeloAndPerdidaBySinister();
}
