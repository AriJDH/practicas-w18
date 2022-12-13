package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.domain.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    Obra save(Obra obra);
    List<Obra> findAll();
    void deleteById(String id);
    Optional<Obra> findByNombreAutor(String nombreAutor);
    List<Obra> findByTituloContaining(String substring);
    List<Obra> findByCantidadPaginasGreaterThan(int pages);
    List<Obra> findByAnioPrimerPublicacionLessThan(int year);
    List<Obra> findByAnioPrimerPublicacionGreaterThan(int year);
    List<Obra> findByEditorialLike(String editorial);
}
