package com.bootcamp.student.repository;

import com.bootcamp.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository <Student, Long> {
}
