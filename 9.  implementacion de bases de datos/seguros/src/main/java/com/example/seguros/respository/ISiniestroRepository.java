package com.example.seguros.respository;

import com.example.seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}
