package com.miniserie.miniserie.repository;

import com.miniserie.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository  extends JpaRepository<MiniSerie, Long> {

}
