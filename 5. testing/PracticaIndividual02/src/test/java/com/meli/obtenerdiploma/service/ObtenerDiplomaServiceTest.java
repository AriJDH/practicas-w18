package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO iStudentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Promedio menor a 9")
    public void analyzeScores() {
        StudentDTO studentCreadoDTO = new StudentDTO();
        studentCreadoDTO.setId(1L);
        studentCreadoDTO.setStudentName("Prueba");

        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO("Matematicas", 9.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Fisica", 7.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Quimica", 6.0);
        subjectDTOs.add(subjectDTO);
        subjectDTOs.add(subjectDTO2);
        subjectDTOs.add(subjectDTO3);

        studentCreadoDTO.setSubjects(subjectDTOs);

        when(iStudentDAO.findById(any())).thenReturn(studentCreadoDTO);

        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(studentDTO.getId(), 1, "El id del estudiante debe ser 1");
        assertEquals(studentDTO.getMessage(), "El alumno Prueba ha obtenido un promedio de 7.33. Puedes mejorar.",
                "El mensaje debe ser -> El alumno Prueba ha obtenido un promedio de 7.33. Puedes mejorar.");
        assertEquals(studentDTO.getStudentName(), "Prueba", "El nombre del estudiante debe ser Prueba");
    }

    @Test
    @DisplayName("Promedio mayor a 9")
    public void analyzeScoresProm9() {

        StudentDTO studentCreadoDTO = TestGenerator.obtenerEstudianteNotas10();

        when(iStudentDAO.findById(any())).thenReturn(studentCreadoDTO);

        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(2L);

        assertEquals(studentDTO.getId(), 2, "El id del estudiante debe ser 2");
        assertEquals(studentDTO.getMessage(), "El alumno Prueba2 ha obtenido un promedio de 10. Felicitaciones!",
                "El alumno Prueba2 ha obtenido un promedio de 10. Felicitaciones!");
        assertEquals(studentDTO.getStudentName(), "Prueba2", "El nombre del estudiante debe ser Prueba2");
    }

    @Test
    @DisplayName("Envio nulo al analyzeScore")
    public void analyzeScoreNull() {
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    @DisplayName("Notas enviadas vacias")
    public void analyzeScore3() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotasVacias();

        when(iStudentDAO.findById(any())).thenReturn(studentDTO);

        StudentDTO studentCalculadoDTO = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        assertEquals(studentCalculadoDTO, studentDTO, "El estudiante creado debe ser igual al promediado");
    }

    @Test
    @DisplayName("Estudiante sin notas")
    public void analyzeScore4() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteSinNotas();

        when(iStudentDAO.findById(any())).thenReturn(studentDTO);

        assertThrows(NullPointerException.class,
                () -> obtenerDiplomaService.analyzeScores(studentDTO.getId()),
                "El servicio debe retornar null pointer");

    }
}
