package com.example.seguros.repository;

import com.example.seguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {

}
