package com.meli.testcasesjpa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "testcases")
public class TestCase {

    // ? =============== Attributes ===============

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;

}
