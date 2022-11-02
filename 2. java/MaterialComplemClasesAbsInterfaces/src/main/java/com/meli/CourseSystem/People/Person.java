package com.meli.CourseSystem.People;

import java.util.Date;

public class Person {
    private String dni;
    private String name;

    public Person(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

}
