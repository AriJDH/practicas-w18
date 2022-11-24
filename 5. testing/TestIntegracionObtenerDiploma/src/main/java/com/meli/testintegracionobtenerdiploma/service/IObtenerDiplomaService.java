package com.meli.testintegracionobtenerdiploma.service;

import com.meli.testintegracionobtenerdiploma.model.StudentDTO;

public interface IObtenerDiplomaService {

    StudentDTO analyzeScores(Long studentId);
}
