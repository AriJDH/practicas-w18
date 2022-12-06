package com.example.test_case_with_mysql.repository;

import com.example.test_case_with_mysql.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {
}
