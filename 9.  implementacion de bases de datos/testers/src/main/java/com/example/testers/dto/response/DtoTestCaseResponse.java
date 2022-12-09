package com.example.testers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoTestCaseResponse {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
}
