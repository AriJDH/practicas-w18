package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel,Long> {
}
