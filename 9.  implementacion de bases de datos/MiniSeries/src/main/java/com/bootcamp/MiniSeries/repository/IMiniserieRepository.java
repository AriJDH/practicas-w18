package com.bootcamp.MiniSeries.repository;

import com.bootcamp.MiniSeries.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {
}
