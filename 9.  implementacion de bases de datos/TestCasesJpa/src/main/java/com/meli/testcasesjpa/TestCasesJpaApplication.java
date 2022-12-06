package com.meli.testcasesjpa;

import com.meli.testcasesjpa.model.TestCase;
import com.meli.testcasesjpa.repository.ITestCaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class TestCasesJpaApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(TestCasesJpaApplication.class, args);
        ITestCaseRepository testCaseRepository = context.getBean(ITestCaseRepository.class);

        TestCase testCase = new TestCase();
        testCase.setIdCase(1L);
        testCase.setDescription("Test description 1");
        testCase.setTested(true);
        testCase.setPassed(true);
        testCase.setNumberOfTries(3);
        testCase.setLastUpdate(LocalDate.now());

        testCaseRepository.save(testCase);

    }

}
