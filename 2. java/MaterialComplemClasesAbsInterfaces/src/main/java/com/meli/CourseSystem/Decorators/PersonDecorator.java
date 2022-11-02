package com.meli.CourseSystem.Decorators;

import com.meli.CourseSystem.Interfaces.IPerson;
import com.meli.CourseSystem.People.Person;

public abstract class PersonDecorator implements IPerson {
    private Person person;

    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public String getDni() {
        return this.person.getDni();
    }

    @Override
    public String getName() {
        return this.person.getName();
    }

}
