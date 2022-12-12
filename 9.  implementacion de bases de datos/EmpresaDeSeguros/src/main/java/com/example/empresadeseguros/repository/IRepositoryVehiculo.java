package com.example.empresadeseguros.repository;

import com.example.empresadeseguros.entity.Vehiculo;
import com.example.empresadeseguros.entity.model.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryVehiculo extends JpaRepository<Vehiculo, Integer> {
    @Query("From Vehiculo")
    List<Vehiculo> findAllVehiculos();

    @Query("From Vehiculo order by anio asc")
    List<Vehiculo> findAllVehiculosOrderbyAnio();

    @Query("From Vehiculo where ruedas > 4 and anio = year(current_date())")
    List<Vehiculo> findAllVehiculos4RuedasCurrentDate();

    @Query("From Vehiculo v inner join Siniestro s on s.vehiculo_id = v.id where s.perdidaEconomica > :perdidaEconomica")
    List<Vehiculo> findAllVehiculosPerdida(@Param("perdidaEconomica") Double perdidaEconomica);

    @Query("select new com.example.empresadeseguros.entity.model.VehiculoSiniestro(v.patente, v.marca, v.modelo, s.perdidaEconomica) From Vehiculo v inner join Siniestro s on s.vehiculo_id = v.id where s.perdidaEconomica > :perdidaEconomica")
    List<VehiculoSiniestro> findAllVehiculosPerdidaTotal(@Param("perdidaEconomica") Double perdidaEconomica);
}
