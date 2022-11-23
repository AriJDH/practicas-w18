package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static StudentDTO obtenerEstudianteNotasVacias() {
        StudentDTO studentCreadoDTO = new StudentDTO();
        studentCreadoDTO.setId(1L);
        studentCreadoDTO.setStudentName("Prueba1");

        List<SubjectDTO> subjectDTOs = new ArrayList<>();

        studentCreadoDTO.setSubjects(subjectDTOs);

        return studentCreadoDTO;
    }

    public static StudentDTO obtenerEstudianteSinNotas() {
        StudentDTO studentCreadoDTO = new StudentDTO();
        studentCreadoDTO.setId(1L);
        studentCreadoDTO.setStudentName("Prueba1");

        return studentCreadoDTO;
    }

    public static StudentDTO obtenerEstudianteNotas10() {
        StudentDTO studentCreadoDTO = new StudentDTO();
        studentCreadoDTO.setId(2L);
        studentCreadoDTO.setStudentName("Prueba2");

        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matematicas", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Fisica", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Quimica", 10.0);
        subjectDTOs.add(subjectDTO);
        subjectDTOs.add(subjectDTO2);
        subjectDTOs.add(subjectDTO3);

        studentCreadoDTO.setSubjects(subjectDTOs);

        return studentCreadoDTO;
    }

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }
}
