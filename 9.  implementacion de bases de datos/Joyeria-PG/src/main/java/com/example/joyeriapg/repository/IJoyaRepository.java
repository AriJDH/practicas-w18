package com.example.joyeriapg.repository;

import com.example.joyeriapg.entity.JoyaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<JoyaEntity, Long> {

}
