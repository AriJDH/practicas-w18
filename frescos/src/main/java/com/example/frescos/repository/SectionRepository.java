package com.example.frescos.repository;

import com.example.frescos.entity.Section;
import com.example.frescos.enums.SectionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    Optional<Section> findBySectionCode(SectionCode sectionCode);

}
