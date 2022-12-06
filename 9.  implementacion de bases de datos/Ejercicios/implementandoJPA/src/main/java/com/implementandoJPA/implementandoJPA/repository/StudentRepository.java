package com.implementandoJPA.implementandoJPA.repository;

import com.implementandoJPA.implementandoJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
