package com.mercadolibre.seguros.repository;

import com.mercadolibre.seguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
