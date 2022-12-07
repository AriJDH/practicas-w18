package com.meli.testcasesjpa.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TestCaseRequest {

    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;

}
