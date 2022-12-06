package example.ejemplo1.repository;

import example.ejemplo1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Mapeo para saber que es un repositorio
@Repository

// Indico que es una extension de JPA la cual recibe dos valores:
// 1. Clase a mapear, 2. Tipo de datos del id de la clase
public interface StudentRepository extends JpaRepository<Student,Long > {
        }
