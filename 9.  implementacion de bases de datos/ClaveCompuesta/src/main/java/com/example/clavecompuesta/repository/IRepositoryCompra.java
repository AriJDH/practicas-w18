package com.example.clavecompuesta.repository;

import com.example.clavecompuesta.entity.Compra;
import com.example.clavecompuesta.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCompra extends JpaRepository<Compra, CompraKey> {
}
