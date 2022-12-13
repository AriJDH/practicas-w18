package com.mercadolibre.Las.Perlas.repository;

import com.mercadolibre.Las.Perlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iJoyaRepository extends JpaRepository<Joya, Long> {
}
