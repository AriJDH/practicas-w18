package com.mercadolibre.Relations.mayoToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    //se usa joinTablo del lado del propietario para crear la tabla intermedia.
    //joinColumns -> define en la tabla intermedia el id de la clase propietaria
    //inverseJoinColumns -> define el id que apunta a la tabla externa de la tabla intermedia.
    @JoinTable(
            name = "courseLiked",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> likedCourses;
}
