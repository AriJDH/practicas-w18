package com.example.crud.dto;

public class StudentDTOUpdateRequest {
    Long id;
    String name;
    String lastname;

    public StudentDTOUpdateRequest(final Long id, final String name, final String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public StudentDTOUpdateRequest() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastname;
    }
}

