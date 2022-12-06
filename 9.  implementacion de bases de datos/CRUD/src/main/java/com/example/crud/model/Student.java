package com.example.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDni() {
        return this.dni;
    }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDni(final String dni) {
        this.dni = dni;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }
}
