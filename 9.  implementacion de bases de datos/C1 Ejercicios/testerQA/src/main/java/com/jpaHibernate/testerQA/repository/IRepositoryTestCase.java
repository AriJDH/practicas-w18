package com.jpaHibernate.testerQA.repository;

import com.jpaHibernate.testerQA.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRepositoryTestCase extends JpaRepository<TestCase, Long> {

    @Query(value = "SELECT * FROM Test_Case tc WHERE tc.last_update >?1", nativeQuery = true)
    List<TestCase> findTestCasesAfterDate(@Param("last_update")LocalDate date);

}
