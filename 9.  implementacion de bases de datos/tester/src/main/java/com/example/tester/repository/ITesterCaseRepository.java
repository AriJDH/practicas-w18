package com.example.tester.repository;

import com.example.tester.model.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITesterCaseRepository extends JpaRepository<TestCase, Long> {
}
