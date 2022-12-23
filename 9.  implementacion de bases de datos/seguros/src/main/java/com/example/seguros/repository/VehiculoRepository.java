package com.example.seguros.repository;

import com.example.seguros.model.Vehiculo;
import com.example.seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> listPatentes();

    @Query("select v.patente, v.marca from Vehiculo v order by v.anioFabricacion")
    List<String[]> findPatentesAndMarca();

    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion = 2022")
    List<String> listPatentesOfVehiculos();

    @Query("select v.patente, v.marca, v.modelo from Vehiculo v " +
            "inner join Siniestro s " +
            "on s.vehiculoSiniestro.id = v.id " +
            "where s.perdidaEconomica > 10000.00")
    List<String[]> listSinisterMount10000();
}
