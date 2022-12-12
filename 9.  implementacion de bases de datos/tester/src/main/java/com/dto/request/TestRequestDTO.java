package com.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    Integer numberOfTries;
    LocalDate lastUpdate;
}
