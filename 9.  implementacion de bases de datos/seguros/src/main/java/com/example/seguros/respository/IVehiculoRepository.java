package com.example.seguros.respository;

import com.example.seguros.model.Vehiculo;
import com.example.seguros.model.entity.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //Consulta 1: listar las patentes de todos los vehículos registrados.
    @Query("select v.patente from Vehiculo v")
    List<String[]> findByPatente();

    //Consulta 2: listar la patente y la marca de todos los vehículos ordenados por año de fabricación.

    //Creación de un objeto donde guardar la consulta
    /*@Query("select new com.example.seguros.model.entities.PatenteAndMarca(v.patente,v.marca) from Vehiculo v order by v.anioFabricacion")
    List<PatenteAndMarca> findByPatenteAndMarca();*/

    //Utilizando HashMap
    /*@Query("select new map(v.patente,v.marca) from Vehiculo v order by v.anioFabricacion")
    List<HashMap<String,String>> findByPatenteAndMarca();*/

    @Query("select v.patente,v.marca from Vehiculo v order by v.anioFabricacion")
    List<String[]> findByPatenteAndMarca();

    //Consulta 3: listar la patente de todos los vehículos que tengan más de cuatro ruedas y han sido
    //fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.ruedas>4 and v.anioFabricacion=2022")
    List<String[]> findByPatenteGreaterThan4RuedasAndAnioFabricacionIs2022();

    //Consulta 4: Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor a 10000 pesos
    @Query("select distinct v.patente, v.marca, v.modelo from Vehiculo v " +
            "inner join Siniestro s where s.vehiculoDenunciado.id = v.id and s.perdidaEconomica>10000")
    List<String[]> findByPatenteAndMarcaAndModelo();

    //Consulta 5: istar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor a 10000 pesos
    //y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("select new com.example.seguros.model.entity.VehiculoSiniestro(v,s.perdidaEconomica) from Vehiculo v " +
            "inner join Siniestro s where s.vehiculoDenunciado.id = v.id and s.perdidaEconomica>10000")
    List<VehiculoSiniestro> findVehiculoSiniestro();


}
