package com.bootcamp.QATester.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;
}
