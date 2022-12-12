package com.repository;

import com.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestRepository extends JpaRepository<Test, Long> {

    @Query(
        value = "SELECT * FROM tests WHERE last_update BETWEEN :lastUpdate AND NOW()",
        nativeQuery = true
    )
    List<Test> findTestByDate(@Param("lastUpdate") String lastUpdate);
}
