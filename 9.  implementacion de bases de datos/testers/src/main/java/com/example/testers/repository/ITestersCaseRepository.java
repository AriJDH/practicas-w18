package com.example.testers.repository;

import com.example.testers.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestersCaseRepository extends JpaRepository<TestCase,Long> {
}
