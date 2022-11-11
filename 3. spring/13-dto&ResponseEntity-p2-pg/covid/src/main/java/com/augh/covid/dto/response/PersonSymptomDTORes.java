package com.augh.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonSymptomDTORes {
    private String name;
    private int age;
    private Map<String, String> severityNameMap;
}
