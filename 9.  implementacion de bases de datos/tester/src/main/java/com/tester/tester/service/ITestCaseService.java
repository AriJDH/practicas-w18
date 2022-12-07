package com.tester.tester.service;

import com.tester.tester.dto.ResponseDTO;
import com.tester.tester.dto.TestCaseDTO;
import org.aspectj.weaver.ast.Test;

import java.util.List;

public interface ITestCaseService {
    public ResponseDTO create(TestCaseDTO test);
    public ResponseDTO delete(Long  id);
    public ResponseDTO update(Long  id, TestCaseDTO test);
    public List<TestCaseDTO> getAll();

    public TestCaseDTO getById(Long id);
}
