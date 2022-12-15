package com.dh.qatester.repository;

import com.dh.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    List<TestCase> findByLastUpdated_After(LocalDate last_updated);

}
