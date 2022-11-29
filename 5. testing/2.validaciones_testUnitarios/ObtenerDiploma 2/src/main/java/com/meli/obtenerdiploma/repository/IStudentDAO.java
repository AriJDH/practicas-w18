package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IStudentDAO {
    StudentDTO save(StudentDTO stu);
    boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}