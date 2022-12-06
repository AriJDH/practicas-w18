package com.example.pruebajap.repository;

import com.example.pruebajap.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {

}
