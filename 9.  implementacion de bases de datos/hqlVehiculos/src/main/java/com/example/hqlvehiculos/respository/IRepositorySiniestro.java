package com.example.hqlvehiculos.respository;

import com.example.hqlvehiculos.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorySiniestro extends JpaRepository<Siniestro,Long> {
}
