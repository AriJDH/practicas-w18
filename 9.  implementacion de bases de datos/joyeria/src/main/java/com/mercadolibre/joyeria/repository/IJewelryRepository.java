package com.mercadolibre.joyeria.repository;

import com.mercadolibre.joyeria.entity.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewerly, Long> {

}
