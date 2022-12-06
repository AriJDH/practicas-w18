package meli.bootcamp.joyerialasperlas.repository;

import meli.bootcamp.joyerialasperlas.entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {
}
