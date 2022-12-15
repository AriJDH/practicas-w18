package com.dh.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDtoReq {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private LocalDate last_updated;
}

// JSON REPRESENTATION
// {
//  "description": "",
//  "tested": false,
//  "passed": false,
//  "number_of_tries": 0,
//  "last_updated": "2022-12-06"
//}