package com.example.segurosautos.repository;

import com.example.segurosautos.entity.Siniestro;
import com.example.segurosautos.entity.model.PatenteModeloMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("select new com.example.segurosautos.entity.model.PatenteModeloMarca(" +
            "s.vehiculoDenunciado.patente, s.vehiculoDenunciado.modelo, s.vehiculoDenunciado.marca)" +
            " from Siniestro s where s.perdidaEconomica > :monto")
    List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestro(@Param("monto") Double monto);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("select new com.example.segurosautos.entity.model.PatenteModeloMarca(" +
            "s.vehiculoDenunciado.patente, s.vehiculoDenunciado.modelo, s.vehiculoDenunciado.marca, sum(s.perdidaEconomica))" +
            "from Siniestro s where s.perdidaEconomica > :monto " +
            "group by s.vehiculoDenunciado.patente, s.vehiculoDenunciado.modelo, s.vehiculoDenunciado.marca")
    List<PatenteModeloMarca> listarVehiculosPorPerdidaEconomicaSiniestroYMontoTotal(@Param("monto") Double monto);
}
