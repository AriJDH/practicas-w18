package com.example.covid.dto;

import com.example.covid.entity.Symptom;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonDTORes {
    private String name;
    private String surname;
    private List<Symptom> symptoms;
}
