package com.meli.hqlhibernatevivoseguros.repository;

import com.meli.hqlhibernatevivoseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //Listar todas las patentes de los vvehiculos
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatent();

    //Listar todas las patentes y marcas de los vehiculos ordenados por año de fabricación
    @Query("SELECT v.patente,v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    HashMap<String, String> findAllPatentBrandOrderByAnioFabricacion();

    //Listar todas las patentes de los vehiculos que se fabricaron el año actual y la cantidad de ruedas es 4
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.anioFabricacion = year(current_date()) AND v.cantidadRuedas = 4")
    List<String> findAllPatentFourWheelActualYear();

}
