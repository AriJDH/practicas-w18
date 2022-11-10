package com.sports.sports.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Person {
    private String name;
    private String lastname;
    private Integer age;
    private Sport personSport;
}
