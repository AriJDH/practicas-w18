package com.CRUDconJPA.JoyeriaLasPerlas.repository;

import com.CRUDconJPA.JoyeriaLasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Long> {
}

