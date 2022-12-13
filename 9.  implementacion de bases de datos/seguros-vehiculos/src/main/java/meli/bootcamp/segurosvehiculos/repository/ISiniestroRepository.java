package meli.bootcamp.segurosvehiculos.repository;

import meli.bootcamp.segurosvehiculos.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
