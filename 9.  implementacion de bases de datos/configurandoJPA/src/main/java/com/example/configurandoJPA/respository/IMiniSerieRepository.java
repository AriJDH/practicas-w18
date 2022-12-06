package com.example.configurandoJPA.respository;

import com.example.configurandoJPA.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
