package com.service;

import com.dto.request.TestRequestDTO;
import com.dto.response.ResponseDTO;
import com.dto.response.TestResponseDTO;
import com.dto.response.TestsResponseDTO;

import java.time.LocalDate;

public interface ITestService {
    ResponseDTO create( TestRequestDTO request);
    TestsResponseDTO getTests(String lastUpdate);
    TestResponseDTO get(Long id);
    ResponseDTO update(Long id,TestRequestDTO request);;
    ResponseDTO delete(Long id);
}
