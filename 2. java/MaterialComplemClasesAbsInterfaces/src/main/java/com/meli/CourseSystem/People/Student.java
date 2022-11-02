package com.meli.CourseSystem.People;

import com.meli.CourseSystem.Decorators.PersonDecorator;
import com.meli.CourseSystem.Interfaces.IStudent;

public class Student extends PersonDecorator implements IStudent {

    public Student(Person person) {
        super(person);
    }

    @Override
    public void toStudy() {
        IStudent.super.toStudy();
    }
}
