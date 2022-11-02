package com.meli.CourseSystem.People;

import com.meli.CourseSystem.Decorators.StudentDecorator;

public class Tutor extends StudentDecorator {

    public Tutor(Student student) {
        super(student);
    }

    public void doTutoring(){
        System.out.println("Dando tutoría...");
    }
}
