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
public class SymptomSeverityDTORes {
    private Map<String, String> severityNameMap;
    private String message;
}
