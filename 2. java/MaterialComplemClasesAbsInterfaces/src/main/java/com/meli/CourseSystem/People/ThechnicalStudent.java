package com.meli.CourseSystem.People;

import com.meli.CourseSystem.Decorators.StudentDecorator;

public class ThechnicalStudent extends StudentDecorator {
    public ThechnicalStudent(Student student) {
        super(student);
    }

    public void giveSupport() {
        System.out.println("Brindar soporte...");
    }
}
