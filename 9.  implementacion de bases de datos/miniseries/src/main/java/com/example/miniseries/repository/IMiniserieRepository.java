package com.example.miniseries.repository;

import com.example.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {

}
