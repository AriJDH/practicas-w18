package com.example.testers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoTestCaseRequest {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
}
