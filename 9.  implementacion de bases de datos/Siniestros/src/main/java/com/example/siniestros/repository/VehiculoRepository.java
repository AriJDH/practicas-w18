package com.example.siniestros.repository;

import com.example.siniestros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT patente FROM Vehiculo")
    List<String> findAllPatentes();
    @Query("SELECT patente, marca FROM Vehiculo ORDER BY anioFabricacion")
    List<String[]> findAllPatentesAndMarcas();
    @Query("SELECT patente FROM Vehiculo WHERE cantidadRuedas=4 AND anioFabricacion=:anio")
    List<String> findAllPatentesVehiculo4RuedasPorAnio(@Param("anio") int anio);
    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v " +
            "INNER JOIN Siniestro s WHERE s.vehiculoDenunciado.id=v.id AND s.perdidaEconomica>10000")
    List<String[]> findAllPatenteMarcaModeloPerdidaMayor10000();
    @Query("SELECT SUM(s.perdidaEconomica) FROM Vehiculo v " +
            "INNER JOIN Siniestro s WHERE s.vehiculoDenunciado.id=v.id AND s.perdidaEconomica>10000")
    Double findAllPatenteMarcaModeloPerdidaPerdidaMayor10000TotalGastado();
}
