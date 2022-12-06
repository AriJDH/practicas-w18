package com.qa.testcase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCaseRequest {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
}
