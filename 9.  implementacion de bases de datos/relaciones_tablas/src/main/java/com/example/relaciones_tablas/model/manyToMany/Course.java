package com.example.relaciones_tablas.model.manyToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Course {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;

}
