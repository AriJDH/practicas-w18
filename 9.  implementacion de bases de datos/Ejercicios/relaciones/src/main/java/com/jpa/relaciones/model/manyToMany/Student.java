package com.jpa.relaciones.model.manyToMany;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable (
            name = "course_like",                                   // nombre tabla intermedia 1 a n
            joinColumns = @JoinColumn(name = "student_id"),         // nombre de la FK en la tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "couser_id")    // nombre de la otra FK en la tabla intermedia
    )
    private Set<Course> likedCourses;


}
