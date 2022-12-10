package com.example.empresadeseguros.repository;

import com.example.empresadeseguros.entity.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface IRepositorySiniestro extends JpaRepository<Siniestro, Integer> {
}
