package com.meli.hqlhibernatevivoseguros.repository;

import com.meli.hqlhibernatevivoseguros.entity.Siniestro;
import com.meli.hqlhibernatevivoseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {

    //buscar vehiculo con siniestro mayor a 10000
    @Query("SELECT V FROM Siniestro S JOIN Vehiculo V WHERE S.perdidaEconomica > 10000")
    List<Vehiculo> findLossGreaterThanTenThousand();

}
