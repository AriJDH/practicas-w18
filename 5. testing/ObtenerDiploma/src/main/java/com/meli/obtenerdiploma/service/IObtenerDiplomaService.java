package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDto;

public interface IObtenerDiplomaService {

    StudentDto analyzeScores(StudentDto rq);
}
