package com.bootcamp.miniserie.repository;

import com.bootcamp.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository  extends JpaRepository<MiniSerie, Long> {
}
