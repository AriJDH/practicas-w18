package com.example.elastic_practice_literature_2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DateDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}
