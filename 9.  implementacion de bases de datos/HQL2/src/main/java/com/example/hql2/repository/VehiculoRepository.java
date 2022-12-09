package com.example.hql2.repository;

import com.example.hql2.entity.Vehiculo;
import com.example.hql2.entity.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> consultaPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioDeFabricacion")
    List<String[]> consultaMarcaYPatenteOrdenadoPorAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedas > 4 AND v.anioDeFabricacion = :anioCorriente")
    List<String> consultarPatenteFabricados(@Param("anioCorriente") Integer anioCorriente);

    @Query("SELECT DISTINCT v.patente, v.marca, v.modelo FROM Vehiculo v INNER JOIN Siniestro s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000")
    List<String[]> consultarVehiculosConSiniestroGrave();

    @Query("SELECT new com.example.hql2.entity.VehiculoSiniestro(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) "
            + "FROM Vehiculo v INNER JOIN Siniestro s ON v.id = s.vehiculo.id WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo ")
    List<VehiculoSiniestro> consultarVehiculosSiniestros();

}
