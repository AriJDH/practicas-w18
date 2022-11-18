package com.example.spring.excepciones.tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String name;
    private boolean isValid;

    public Link(String name){
        this.name = name;
        isValid = true;
    }
}
