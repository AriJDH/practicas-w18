package com.bootcamp.QATester.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class TestCaseReqDto {

    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;
}
