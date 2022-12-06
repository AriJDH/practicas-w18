package com.example.crud.dto;

public class StudentDTONewRequest {
    private String dni;
    private String name;
    private String lastname;

    public StudentDTONewRequest(final String dni, final String name, final String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }

    public StudentDTONewRequest() {
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
}
