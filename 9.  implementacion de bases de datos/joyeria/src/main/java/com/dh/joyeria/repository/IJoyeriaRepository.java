package com.dh.joyeria.repository;

import com.dh.joyeria.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya, Long> {

    List<Joya> findByVentaONoTrue();

    @Transactional
    @Modifying
    @Query("update Joya j set j.ventaONo = false where j.id = ?1")
    void updateJoyaVentaONo(Long id);




}
