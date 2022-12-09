package com.example.manytomany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    //tabla intermedia que se crea
    @JoinTable(
            name="course_like", //nombre de la tabla intermedia
            joinColumns = @JoinColumn(name="student_id"), //columnas que se van a unir
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private Set<Course> likedCourses;
}
