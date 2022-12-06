package meli.bootcamp.miniseries.repository;

import meli.bootcamp.miniseries.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<Serie, Long> {
}
