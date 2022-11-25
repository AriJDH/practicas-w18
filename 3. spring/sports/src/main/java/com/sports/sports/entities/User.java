package com.sports.sports.entities;

import java.util.ArrayList;

public class User {
    private String name;
    private String lastName;
    private int age;
    private ArrayList<Sport> sports;

    public User(String name, String lastName, int age, ArrayList<Sport> sports) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                "sports" + sports +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
