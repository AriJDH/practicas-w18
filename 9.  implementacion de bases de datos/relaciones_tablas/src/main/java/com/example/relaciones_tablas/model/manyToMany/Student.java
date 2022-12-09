package com.example.relaciones_tablas.model.manyToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courseSet;
}
