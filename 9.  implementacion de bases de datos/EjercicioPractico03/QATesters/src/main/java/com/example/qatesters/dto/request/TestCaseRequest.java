package com.example.qatesters.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class TestCaseRequest {

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

}
