package com.example.relacionesjpa.entity.ManyToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @ManyToMany(mappedBy = "linkedCourses")
    Set<StudentManyToMany> students;
}
