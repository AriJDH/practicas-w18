package com.meli.envivotestcase.repository;

import com.meli.envivotestcase.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase,Long> {

    //CONSULTA CON HQL
    @Query("SELECT T FROM TestCase T WHERE T.lastUpdate >= :lastDate")
    public List<TestCase> findAllByAfterLastUpdate(@Param("lastDate")LocalDate lastDate);

    //CONSULTA AUTOGENERADA
    public List<TestCase> findAllByLastUpdateIsAfter(LocalDate lastDate);

}
