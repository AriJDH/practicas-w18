package com.miniseries.repository;

import com.miniseries.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
