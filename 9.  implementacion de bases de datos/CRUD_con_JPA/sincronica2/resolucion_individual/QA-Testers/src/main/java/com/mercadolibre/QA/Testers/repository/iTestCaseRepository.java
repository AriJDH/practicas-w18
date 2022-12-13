package com.mercadolibre.QA.Testers.repository;

import com.mercadolibre.QA.Testers.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface iTestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findTestCaseByLastUpdate(LocalDate last_update);
}
