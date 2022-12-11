package com.example.hqlvehiculos.respository;

import com.example.hqlvehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public interface IRepositoryVehiculo extends JpaRepository<Vehiculo,Long> {
    //  QUERYS
    //Listar las patentes de todos los vehiculos registrados
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findPatentes();

    @Query("FROM Vehiculo v where v.id = :id")
    Vehiculo findVehicleById(Long id);

    //Listar la patente y marca de todos los vehiculos registrados ordenados por año de fabricacion
    @Query("select v.patente as patente, v.marca as marca from Vehiculo v order by v.anioFabricacion")
    List<String> findPatentesMarca();

    //Listar la patente de todos los vehículos que
    //tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    Calendar fecha = new GregorianCalendar();
    int anio = fecha.get(Calendar.YEAR);
    @Query("select v.patente from Vehiculo v where v.cantRuedas > 4") //and v.anioFabricacion = :anio
    List<String> findPatentesRuedas();

    //Listar la matrícula, marca y modelo
    //de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.

    @Query("select v.patente, v.marca, v.modelo from Vehiculo v " +
            "inner join Siniestro s where s.vehiculoDenunciado.id = v.id and s.perdida > 10000")
    List<String> findPatenteMarcaModeloPerdida();


}
