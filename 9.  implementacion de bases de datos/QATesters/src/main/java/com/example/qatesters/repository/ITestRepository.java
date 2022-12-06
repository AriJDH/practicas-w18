package com.example.qatesters.repository;

import com.example.qatesters.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestRepository extends JpaRepository<TestCase, Long> {
    @Query("FROM TestCase t WHERE t.last_update >:lastUpdate")
    Optional<List<TestCase>> findByLastUpdated(@Param ("lastUpdate") LocalDate lastUpdate);
}
