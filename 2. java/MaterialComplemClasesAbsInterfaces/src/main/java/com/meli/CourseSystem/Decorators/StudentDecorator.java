package com.meli.CourseSystem.Decorators;

import com.meli.CourseSystem.People.Student;

public abstract class StudentDecorator {
    private Student student;

    public StudentDecorator(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
