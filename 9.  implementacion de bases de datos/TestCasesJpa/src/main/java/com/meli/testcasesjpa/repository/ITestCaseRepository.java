package com.meli.testcasesjpa.repository;

import com.meli.testcasesjpa.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    // ? =============== Queries ===============

    List<TestCase> findAllByLastUpdateAfter(LocalDate date);

}
