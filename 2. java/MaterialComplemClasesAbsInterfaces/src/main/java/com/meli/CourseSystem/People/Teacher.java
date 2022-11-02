package com.meli.CourseSystem.People;

import com.meli.CourseSystem.Decorators.PersonDecorator;

public class Teacher extends PersonDecorator {

    public Teacher(Person person) {
        super(person);
    }

    public void toTeach() {
        System.out.println("Enseñando...");
    }
}
