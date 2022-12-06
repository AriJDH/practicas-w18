package com.example.test_case_with_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class SearchTestDTO {

    private List<TestDTO> testDTOs;

}
