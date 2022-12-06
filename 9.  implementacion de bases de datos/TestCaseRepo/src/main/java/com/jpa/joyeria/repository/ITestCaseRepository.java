package com.jpa.joyeria.repository;

import com.jpa.joyeria.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query("select t from TestCase t where t.last_update >= ?1")
    List<TestCase> findByLastUpdate(LocalDate lastUpdate);

}
