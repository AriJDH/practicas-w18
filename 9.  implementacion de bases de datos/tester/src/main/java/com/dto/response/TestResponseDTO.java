package com.dto.response;

import com.model.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestResponseDTO {
    Long IdCase;
    String description;
    Boolean tested;
    Boolean passed;
    Integer numberOfTries;
    LocalDate lastUpdate;
}
