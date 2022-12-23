package com.example.qatester.repository;

import com.example.qatester.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {

    @Query("select tc from TestCase tc where tc.description like :description")
    List<TestCase> findDescription(@Param("description") String description);
}
