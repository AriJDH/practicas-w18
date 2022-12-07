package com.PasoPasoEjerciciosVivo.QATesters.repository;

import com.PasoPasoEjerciciosVivo.QATesters.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
