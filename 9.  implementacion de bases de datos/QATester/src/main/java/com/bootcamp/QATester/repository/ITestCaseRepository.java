package com.bootcamp.QATester.repository;

import com.bootcamp.QATester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    @Query("from TestCase t where t.lastUpdate > :localDate")
   Optional<List<TestCase>> findAfterDate(@Param("localDate") LocalDate localDate);
}
