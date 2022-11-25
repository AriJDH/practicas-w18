package com.example.covid19.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Person {
    Integer id;
    String name, lastname;
    Integer age;
    List<Symptom> symptoms;
}
