package com.bootcamp.qatester.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCaseDtoRequest{
        private String description;
        Boolean tested;
        Boolean passed;
        int numberOfTries;
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate lastUpdate;
}
