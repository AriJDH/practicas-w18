package com.mercadolibre.seguros.repository;

import com.mercadolibre.seguros.entity.Vehiculo;
import com.mercadolibre.seguros.entity.otros.PatenteMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    /**
     TODO Listar las patentes de todos los vehículos registrados.
     */
    @Query("select v.patente from Vehiculo v")
    List<String> getPatentes();
    /**
     TODO Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
     */
    //Con el objeto custom
    /*@Query("select new com.mercadolibre.seguros.entity.otros.PatenteMarca(v.patente, v.marca) from Vehiculo v order by v.anioFabricacion")
    List<PatenteMarca> getPatenteMarcaOrdenadosPorAnio();*/
    //Con Mapa
    @Query("select new map(v.patente, v.marca) from Vehiculo v order by v.anioFabricacion")
    List<HashMap<String, String>> getPatenteMarcaOrdenadosPorAnio();

    /**
     TODO Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
     */
    /**
     TODO Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
     */
    /**
     TODO Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos
     */
}
