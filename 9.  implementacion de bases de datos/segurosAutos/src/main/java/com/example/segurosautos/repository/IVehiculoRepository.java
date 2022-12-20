package com.example.segurosautos.repository;

import com.example.segurosautos.entity.Vehiculo;
import com.example.segurosautos.entity.model.PatenteModeloMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //Listar las patentes de todos los vehículos registrados
    @Query("select v.patente from Vehiculo v")
    List<String> listarPatentes();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("select new com.example.segurosautos.entity.model.PatenteModeloMarca(v.patente, v.marca) " +
            "from Vehiculo v order by v.anioFabricacion")
    List<PatenteModeloMarca> listarPatenteYMarca();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.ruedas = :ruedas and v.anioFabricacion = :anio")
    List<String> listarPatentesPorRuedasYAnio(@Param("ruedas") Integer ruedas, @Param("anio") Integer anio);

}
