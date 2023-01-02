package com.mercadolibre.pf_be_java_hisp_w18_g1.repository;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findAllBySectionCode(SectionCode sectionCode);
    Section findBySectionCode(SectionCode sectionCode);
    Optional<Section> findById(Long id);
    List<Section> findAll();

}
