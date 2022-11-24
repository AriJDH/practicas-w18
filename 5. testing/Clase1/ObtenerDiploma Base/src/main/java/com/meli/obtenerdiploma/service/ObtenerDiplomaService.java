package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        StudentDTO studentDTOres = new StudentDTO();
        String name = rq.getStudentName();
        studentDTOres.setStudentName(name);
        double average = Math.round(calculateAverage(rq.getSubjects()) * 100.0) / 100.0;
        studentDTOres.setAverageScore(average);
        studentDTOres.setSubjects(rq.getSubjects());
        String message =String.format("El Alumno %s ha obtenido un promedio de " + average, name);
        studentDTOres.setMessage(message);
        return studentDTOres;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
