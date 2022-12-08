package com.bootcamp.qatester.repository;

import java.time.LocalDate;
import java.util.List;

import com.bootcamp.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
    List<TestCase> findAllByLastUpdateAfter(LocalDate date);
}
