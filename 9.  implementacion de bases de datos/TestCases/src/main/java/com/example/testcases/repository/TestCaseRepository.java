package com.example.testcases.repository;

import com.example.testcases.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query(value = "SELECT * FROM TEST_CASE u WHERE u.last_update > ?1", nativeQuery = true)
    List<TestCase> findAllTestCasesUpdatedAfterDate(@Param("date") LocalDate date);
}
