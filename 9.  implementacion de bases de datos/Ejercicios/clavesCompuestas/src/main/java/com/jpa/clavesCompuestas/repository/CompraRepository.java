package com.jpa.clavesCompuestas.repository;

import com.jpa.clavesCompuestas.model.Compra;
import com.jpa.clavesCompuestas.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
