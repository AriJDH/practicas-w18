package com.meli.testintegracionobtenerdiploma.repository;

import com.meli.testintegracionobtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}
