package com.bootcamp.qatester.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDtoResponse {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
