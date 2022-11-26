package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentDAO {
	
	Set<StudentDTO> findAll();
	
	void save(StudentDTO stu);
	
	boolean delete(Long id);
	
	boolean exists(StudentDTO stu);
	
	StudentDTO findById(Long id);
}