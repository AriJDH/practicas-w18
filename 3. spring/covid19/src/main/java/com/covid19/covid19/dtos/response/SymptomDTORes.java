package com.covid19.covid19.dtos.response;

import com.covid19.covid19.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTORes {
    private String name;
    private Level severity;
}
