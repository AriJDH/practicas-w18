package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.domain.Obra;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    Obra save(Obra obra);

    List<Obra> findAll();

    void deleteById(String id);
    Optional<Obra> findByNombreAutor(String nombreAutor);
    @Query("  {\n" +
            "    \"multi_match\": {\n" +
            "      \"query\": \"?0\",\n" +
            "      \"fields\": [\"titulo\"]\n" +
            "    }\n" +
            "  }")
    List<Obra> findByTitleSubstring(String substring);
    @Query("{\"range\" : {\n" +
            "    \"cantidadPaginas\" : {\n" +
            "        \"gt\" : ?0\n" +
            "    }\n" +
            "}}")
    List<Obra> findByPagesGreaterThan(int pages);
    @Query("{\"range\" : {\n" +
            "    \"anioPrimerPublicacion\" : {\n" +
            "        \"lt\" : ?0\n" +
            "    }\n" +
            "}}")
    List<Obra> findAllPublishedBefore(int year);
    @Query("{\"range\" : {\n" +
            "    \"anioPrimerPublicacion\" : {\n" +
            "        \"gt\" : ?0\n" +
            "    }\n" +
            "}}")
    List<Obra> findAllPublishedAfter(int year);
    @Query("{\"match_phrase\": {\n" +
            "            \"editorial\": \"?0\"\n" +
            "        }}")
    List<Obra> findAllByEditorial(String editorial);
}
