package com.example.qatesters.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseResponse {

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

}
