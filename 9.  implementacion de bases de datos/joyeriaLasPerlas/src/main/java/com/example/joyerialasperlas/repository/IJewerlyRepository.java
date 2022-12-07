package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly,Long> {
}
