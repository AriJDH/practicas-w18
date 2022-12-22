package com.example.qatesters.repository;

import com.example.qatesters.entity.TestCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCaseEntity, Long> {
}
