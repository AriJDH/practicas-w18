package com.example.testcase.repository;

import com.example.testcase.model.Testcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestcaseRepository extends JpaRepository<Testcase,Long> {
    List<Testcase> findAllByLastUpdateAfter(LocalDate date);
}
