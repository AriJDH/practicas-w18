package com.example.covid19.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Symptom {
    String code, name, severity_level;

    @Override
    public String toString() {
        return "Symptom{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", severity_level='" + severity_level + '\'' +
                '}';
    }
}
