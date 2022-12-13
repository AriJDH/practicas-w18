package com.example.relacionesjpa.entity.ManyToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @ManyToMany
    @JoinTable(
            name="course_stu",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Set<Course> linkedCourses;
}
