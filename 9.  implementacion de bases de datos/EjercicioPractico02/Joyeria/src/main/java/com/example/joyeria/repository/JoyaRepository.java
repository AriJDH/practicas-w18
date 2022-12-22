package com.example.joyeria.repository;

import com.example.joyeria.entity.JoyaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<JoyaEntity, Long> {
}
