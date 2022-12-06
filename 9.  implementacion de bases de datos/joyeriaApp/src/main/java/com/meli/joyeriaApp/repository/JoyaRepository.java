package com.meli.joyeriaApp.repository;


import com.meli.joyeriaApp.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya,Long> {
}
