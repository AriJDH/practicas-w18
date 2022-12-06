package com.example.joyeria_lasperlas.repository;

import com.example.joyeria_lasperlas.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryJewerly extends JpaRepository<Jewel, Long> {
}
