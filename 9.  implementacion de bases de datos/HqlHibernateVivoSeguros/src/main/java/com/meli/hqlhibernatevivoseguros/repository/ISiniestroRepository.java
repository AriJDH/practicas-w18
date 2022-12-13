package com.meli.hqlhibernatevivoseguros.repository;

import com.meli.hqlhibernatevivoseguros.entity.Siniestro;
import com.meli.hqlhibernatevivoseguros.dto.VehiculoPerdidaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {


    //buscar vehiculo con siniestro mayor a 10000
    @Query(value="SELECT new com.meli.hqlhibernatevivoseguros.dto.VehiculoPerdidaDTO( V,S.perdidaEconomica ) FROM Vehiculo V JOIN V.siniestroList S WHERE S.perdidaEconomica > 10000")
    List<VehiculoPerdidaDTO> findLossGreaterThanTenThousand();

}
