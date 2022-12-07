package com.example.siniestros.repository;

import com.example.siniestros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
