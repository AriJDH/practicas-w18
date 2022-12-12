package com.example.obrasliterarias.service;

import com.example.obrasliterarias.domain.Obra;

import java.util.List;

public interface ObraDbService {
    Obra save(Obra obra);
    List<Obra> findAll();
    void deleteById(String id);
    Obra findByNombreAutor(String nombreAutor);
    List<Obra> findByTitleSubstring(String substring);
    List<Obra> findByPagesGreaterThan(int pages);
    List<Obra> findAllPublishedBefore(int anio);
    List<Obra> findAllPublishedAfter(int anio);
    List<Obra> findAllByEditorial(String editorial);
}
