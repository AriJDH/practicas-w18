package com.example.clavescompuestas.repository;

import com.example.clavescompuestas.model.Compra;
import com.example.clavescompuestas.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, CompraKey> {
}
