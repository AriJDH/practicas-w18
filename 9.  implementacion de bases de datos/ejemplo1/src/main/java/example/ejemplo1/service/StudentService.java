package example.ejemplo1.service;

import example.ejemplo1.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service    //Mapeo el servicio

public class StudentService {

    //--Mencion al repositorio
    private final StudentRepository stuRep;

    //---Constructor
    public StudentService(StudentRepository stuRep) {
        this.stuRep = stuRep;
    }
}

