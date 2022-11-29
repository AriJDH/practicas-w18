package com.meli.obtenerdiploma.unit.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class StudentDTOFactory {
    public static StudentDTO utilNewStudentDto(Long id, String name, List<SubjectDTO> subjects){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName(name);
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}
